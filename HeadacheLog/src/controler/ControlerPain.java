package controler;

/**
 * A classe ControlerPain estabelece uma ligação entre a classe  {@link Pain} (model) e a {@link MainScreen} (view).
 * 
 * Implementa a Interface CRUD
 * 
 * <p>
 * Essa classe é responsável por gerenciar as dores de cabeça
 * <p>
 * 
 * @see Pain
 * @see CRUD
 * @author Ana Luiza Rodrigues da Silva
 */

import model.Crud;
import model.Pain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControlerPain implements Crud {
	
	private ArrayList<Pain> pain = new ArrayList<>();
	
	/**
	 * O construtor padrão da classe, com dados mocados.
	 */
	
	public ControlerPain() {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			pain.add(new Pain(format.parse("10/01/2021"), "Pressão", "Lado Direito", 2, 2, "sono"));
			pain.add(new Pain(format.parse("15/11/2021"), "Pressão", "Lado Direito", 2, 5, "sono"));
			pain.add(new Pain(format.parse("02/02/2022"), "Latejante", "Lado Direito", 3, 7, "ansiedade"));
			pain.add(new Pain(format.parse("29/06/2022"), "Pulsadas", "Lado Esquerdo", 1, 2, "comida"));
			pain.add(new Pain(format.parse("25/05/2022"), "Pressão", "Dois Lados", 2, 5, "estresse"));
			pain.add(new Pain(format.parse("10/06/2022"), "Pulsadas", "Lado Esquerdo", 2, 5, "sono"));
			pain.add(new Pain(format.parse("04/06/2022"), "Pulsadas", "Lado Direito", 2, 5, "sono"));
		} catch (ParseException e) {
		}
	}
	
	
	/**
	 * Esse método cria uma nova Pain.
	 * É um método implementado da Interface CRUD.
	 * 
	 * @param Objeto, objeto a ser adicionado na lista
	 * @return Retorna true ou false
	 */
	@Override
	public boolean create(Object controlerPain) {
		if (controlerPain != null) {
			pain.add((Pain) controlerPain);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Esse método procura uma dor na lista.
	 * É um método implementado da Interface CRUD.
	 * @param Data utilizada para procurar uma dorna lista.
	 * @return Retorna uma lista com um objeto do tipo Pain.
	 */
	@Override
	public ArrayList<Pain> read(Date date) {
		ArrayList<Pain> list = new ArrayList<>();
		for(Pain p:pain) {
			if(p.getDate().equals(date)) {
				list.add(p);
			}
		}
		return list;
	}
	
	/**
	 * Esse método atualiza uma dor.
	 * É um método implementado da Interface CRUD.
	 * @param Data utilizada para pesquisar uma dor na lista.
	 * @return Retorna true ou false.
	 */
	@Override
	public boolean update(Date date) {
		for(Pain p:pain) {
			if(p.getDate().equals(date)) {
				pain.remove(p);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Esse método deleta uma dor.
	 * É um método implementado da Interface CRUD.
	 * @param Data utilizada para pesquisar a dor.
	 * 
	 */
	@Override
	public void delete(Date date) {
		int index =0;
		for(Pain p:pain) {
			if(p.getDate().equals(date)) {
				pain.remove(index);
				break;
			}
			index ++;
		}
	}
	
	/**
	 * Esse método retorna todas as dores na lista.
	 * @return Array de objetos do tipo Pain.
	 */
	public ArrayList<Pain> getPain() {
		return pain;
	}
	
	/**
	 * Esse método faz uma consulta num período de tempo.
	 * @param startDate data inicial.
	 * @param endDate data final.
	 * @return Retorna um Array de objetos do tipo Pain que existem no intervalo de tempo das datas nos parâmetros.
	 */
	public ArrayList<Pain> consultDate(Date startDate, Date endDate) {
		ArrayList<Pain> list = new ArrayList<>();
		for (Pain p : pain) {
			if ((p.getDate().after(startDate) || p.getDate().equals(startDate))
					&& (p.getDate().before(endDate) || p.getDate().equals(endDate))) {
				list.add(p);
			}
		}
		return list;
	}
	
	/**
	 * Esse método mostra o total de dores cadastradas.
	 * @return Retorna o número de dores cadastradas.
	 */
	public String totalPain() {
		return String.valueOf(pain.size());
	}
	
	/**
	 * Esse método calcula a intensidade média das dores.
	 * @return Retorna a média aritimética das dores.
	 */
	public String calcMedia() {
		double sum = 0;
		for (Pain p : pain) {
			sum += p.getIntensity();
		}
		double media = sum / pain.size();
		return String.format("%.2f", media);
	}
	
	/**
	 * Esse método mostra a área mais comum das dores.
	 * @return Retorna a área mais comum das dores.
	 */
	public String commonArea() {
		int countRightSide = 0, countLeftSide = 0, countBothSides = 0, bigger = 0, i;
		for (Pain p : pain) {
			if (p.getArea().equals("Lado Direito"))
				countRightSide++;
			if (p.getArea().equals("Lado Esquerdo"))
				countLeftSide++;
			if (p.getArea().equals("Dois Lados"))
				countBothSides++;
		}
		int vector[] = new int[3];
		vector[0] = countRightSide;
		vector[1] = countLeftSide;
		vector[2] = countBothSides;
		for (i = 0; i < vector.length; i++) {
			if (vector[i] > bigger) {
				bigger = vector[i];
			}
		}
		if (bigger == vector[0])
			return "Lado Direito".toUpperCase();
		else if (bigger == vector[1])
			return "Lado Esquerdo".toUpperCase();
		else
			return "Dois Lados".toUpperCase();
	}
	
	/**
	 * Esse método mostra o tipo de dor mais comum.
	 * @return Retorna a dor mais comum.
	 */
	public String commonPain() {
		
		int pressure = 0, pulsing = 0, throbbing = 0, bigger = 0, i;
			for (Pain p : pain) {
				if (p.getVariety().equals("Pressão"))
					pressure++;
				if (p.getVariety().equals("Pulsadas"))
					pulsing++;
				if (p.getVariety().equals("Latejante"))
					throbbing++;
			}
			int vector[] = new int[3];
			vector[0] = pressure;
			vector[1] = pulsing;
			vector[2] = throbbing;
			for (i = 0; i < vector.length; i++) {
				if (vector[i] > bigger) {
					bigger = vector[i];
				}
			}
			if (bigger == vector[0]) 
				return "Pressão".toUpperCase();
			else if (bigger == vector[1])
				return "Pulsadas".toUpperCase();
			else
				return "Latejante".toUpperCase();

	}
	
	/**
	 * Esse método verifica se a data escolhida já pertence a uma dor na lista.
	 * @param date Utilizada para comparação com datas da lista.
	 * @return Retorna true ou false.
	 */
	public boolean checkDate(Date date) {
		for(Pain p: pain) {
			if(p.getDate().equals(date)) {
				return true;
			}
		}
		return false;
	}

}
