package br.scp.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.scp.controle.Controle;
import br.scp.modelo.Empresa;
import br.scp.modelo.EmpresaDAO;

public class UC04CadastrarEmpresaTest {
	static public Empresa empresa;
	static public Controle controle;
	static public EmpresaDAO empresaDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controle = new Controle();
		empresa = new Empresa();
		empresa.setCnpj("02683322000108");
		empresa.setRazaoSocial("grupo pao de acucar");
		empresa.setHorarioEntrada(8);
		empresa.setHorarioSaida(18);
		empresa.setTemperaturaHI(8);
		empresa.setTemperaturaHT(18);
		empresa.setTemperaturaMaxima(21);
		empresa.setConjuntos(111);
		empresa.setConjuntos(112);
		empresa.setConjuntos(113);
	}
	@Test
	public void CT01UC04FBcadastrar_com_sucesso() {
		assertEquals (3,empresa.getConjuntos().size());
	}
	@Test
	public void CT02UC04FBcadastrar_com_sucesso() {
		assertEquals ("cadastro realizado com sucesso",controle.setAtributos("02683322000108", "grupo pao de acucar", "rua taquari","8", "18", "111", "112", "113", "21","8","18"));
	}
	/*
	 * teste de cnpj
	 */
	@Test
	public void CT03UC04FBcadastrar_empresa_cnpj_invalido() {
		assertEquals ("dados invalidos",controle.setAtributos("026833220001081", "grupo pao de acucar","rua taquari", "8", "18", "111", "112", "113", "21","8","18"));
	}
	/*
	 * teste de cnpj
	 */
	@Test
	public void CT04UC04FBcadastrar_empresa_cnpj_invalido() {
		empresaDAO = new EmpresaDAO();
		assertEquals (1, empresaDAO.adiciona(empresa));
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

}

