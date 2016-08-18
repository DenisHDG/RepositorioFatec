package br.scp.modelo;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Empresa {
	String cnpj;
	String razaoSocial;
	String endereco;
	String telefone;
	int horarioEntrada;
	int horarioSaida;
	ArrayList<Conjunto> conjuntos;
	ControleDeTemperatura controleDeTemperatura;
	public Empresa(){
		conjuntos = new ArrayList<Conjunto>();
		controleDeTemperatura = new ControleDeTemperatura();
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCnpj() {
		return cnpj;
	}
	/*
	 * atribui o cnpj vefica se o cnpj valido
	 */
	public void setCnpj(String cnpj)  {
		if (isValido(cnpj)){
			this.cnpj = cnpj;
		}
		else
			throw new IllegalArgumentException("CNPJ inválido!");
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		if (razaoSocial.equals(""))
			throw new IllegalArgumentException("Razao social invalida");
		else
		this.razaoSocial = razaoSocial;
	}
	public void setEndereco(String end){
		this.endereco = end;
	}
	public String getEndereco(){
		return endereco;
	}
	public int getHorarioEntrada() {
		return horarioEntrada;
	}
	public void setHorarioEntrada(int horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	public int getHorarioSaida() {
		return horarioSaida;
	}
	public void setHorarioSaida(int horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	public ArrayList<Conjunto> getConjuntos() {
		return conjuntos;
	}
	public void setConjuntos(int numero) {
		Conjunto c = new Conjunto();
		c.setNumeroConjunto(numero);
		conjuntos.add(c);
	}
	public void setTemperaturaHI(int hi){
		controleDeTemperatura.setHorarioInicio(hi);
	}
	public void setTemperaturaHT(int ht){
		controleDeTemperatura.setHorarioInicio(ht);
	}
	public void setTemperaturaMaxima(int temp){
		controleDeTemperatura.setTemperaturaMaxima(temp);
	}
	/*
	 * valida o cnpj
	 */
	public boolean isValido(String cnpj) {
		char dig13, dig14; 
		int sm, i, r, num, peso;
		if (cnpj.equals("00000000000000") || 
				cnpj.equals("11111111111111") || 
				cnpj.equals("22222222222222") || 
				cnpj.equals("33333333333333") || 
				cnpj.equals("44444444444444") || 
				cnpj.equals("55555555555555") ||
				cnpj.equals("66666666666666") || 
				cnpj.equals("77777777777777") || 
				cnpj.equals("88888888888888") || 
				cnpj.equals("99999999999999") || 
				(cnpj.length() != 14)) {
			return(false); 
		}
		// "try" - protege o código para eventuais erros de conversao de tipo (int) 
		try { // Calculo do 1o. Digito Verificador 
			sm = 0; 
			peso = 2; 
			for (i=11; i>=0; i--) { 
				// converte o i-esimo caractere do CNPJ em um numero: 
				// por exemplo, transforma o caractere '0' no inteiro 0 
				// (48 eh a posicao de '0' na tabela ASCII) 
				num = (int)(cnpj.charAt(i) - 48); 
				sm = sm + (num * peso); 
				peso = peso + 1; if (peso == 10) 
					peso = 2; 
			} 
			r = sm % 11; 
			if ((r == 0) || (r == 1)) 
				dig13 = '0'; 
			else 
				dig13 = (char)((11-r) + 48);
		
		// Calculo do 2o. Digito Verificador 
		sm = 0; peso = 2; 
		for (i=12; i>=0; i--) { 
			num = (int)(cnpj.charAt(i)- 48); 
			sm = sm + (num * peso); peso = peso + 1; 
			if (peso == 10) peso = 2; 
			} 
		r = sm % 11; 
		if ((r == 0) || (r == 1)) dig14 = '0';
		else dig14 = (char)((11-r) + 48); 
		// Verifica se os digitos calculados conferem com os digitos informados. 
		if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) 
			return(true); else return(false);
		}
		catch (InputMismatchException erro) {
			erro.printStackTrace();
	        return(false);
	    }
	}
}
