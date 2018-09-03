package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categorias;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Pagamento;
import com.example.demo.domain.PagamentoComBoleto;
import com.example.demo.domain.PagamentoComCartao;
import com.example.demo.domain.Pedido;
import com.example.demo.domain.Produto;
import com.example.demo.domain.enums.EstadoPagamento;
import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.Enderecorepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.PagametoRepository;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.ProdutosRepository;





@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository caterogiaRepository;
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private Enderecorepository enderecorepository;
	@Autowired
	private PedidoRepository pedidoRepository;
    @Autowired
    private PagametoRepository pagametoRepository;
    

	public static void main(String[] args) {
		
		SpringApplication.run(CursomcApplication.class, args);
		
		
	
	}
	
	public void run(String...args) throws Exception {
		
		Categorias cat1 = new Categorias(null,"Informatica");
		Categorias cat2 = new Categorias(null,"Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 8000.00);
		Produto p2 = new Produto(null, "Ventilador", 200.00);
		Produto p3 = new Produto(null, "Show", 50.00);		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 , p3));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat2));
		
		
		caterogiaRepository.saveAll(Arrays.asList(cat1 ,cat2));
		produtosRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"Sao Paulo");
		Estado est3 = new Estado(null,"Rio de janeiro");
		
		Cidade cid1 = new Cidade(null,"BH", est1);
		Cidade cid2 = new Cidade(null,"Campinas", est2);
		Cidade cid3 = new Cidade(null,"Niteroi", est3);
		Cidade cid4 = new Cidade(null,"SP", est2);
		
		
		est1.getCidadesList().addAll(Arrays.asList(cid1));
		est2.getCidadesList().addAll(Arrays.asList(cid2,cid4));
		est3.getCidadesList().addAll(Arrays.asList(cid3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3,cid4));
		
		
		Cliente cli1 = new Cliente(null, "Maria" , "maria@naosei.com" , "00000000000", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Juliana", "ju@felicio.com" , "1111111" , TipoCliente.PESSOAFISICA);
		Cliente cli3 = new Cliente(null, "Fernando", "Fernando@crp.com", "22222222222", TipoCliente.PESSOAJURIDICA);
		
		cli1.getTelefones().addAll(Arrays.asList("123456","182829"));
		
		cli2.getTelefones().addAll(Arrays.asList("987654312"));
		
		cli3.getTelefones().addAll(Arrays.asList("15896547", "18859648", "18555484"));
		
		
		Endereco end1 = new Endereco(null,"Rua 1", "300" , " AP1", "Jardim", "185485", cli1 , cid1);
		Endereco end2 = new Endereco(null, "409 Norte" , "SN", "Lt11", "PDN", "0018548", cli2, cid2);
		Endereco end3 = new Endereco(null, "507 S", "SN", "QI26", "PDS", "00151515", cli3, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1));
		cli2.getEnderecos().addAll(Arrays.asList(end2,end3));
		cli3.getEnderecos().addAll(Arrays.asList(end3, end2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		enderecorepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		
		Pedido pedido1 = new Pedido(null,sdf.parse("30/09/2017 10:32"), cli1 , end1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end1);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1 , 6);
		pedido1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), sdf.parse("21/10/2017 00:00"));
		pedido2.setPagamento(pag2);
		
		
		cli1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		//pagametoRepository.saveAll(Arrays.asList(pag1, pag2));
			
	}
}
