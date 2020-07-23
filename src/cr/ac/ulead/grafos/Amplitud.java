package cr.ac.ulead.grafos;

import java.io.*;
import java.util.*;

public class Amplitud {

		public int[][] g = {{2, 1, 0, 1, 0},
				{1, 2, 1, 0, 0},
				{0, 1, 2, 1, 0},
				{1, 0, 1, 2, 1},
				{0, 0, 0, 1, 2}};
		private boolean[] visitiadoAnchura = new boolean[5];


		public Amplitud() {
		}

		public int[][] getG() {
			return g;
		}

		public ArrayList<Integer> recorridoAnchura(int nodoI) {
//Lista donde guardo los nodos recorridos
			ArrayList<Integer> recorridos = new ArrayList<Integer>();
//El nodo inicial ya está visitado
			visitiadoAnchura[nodoI] = true;
//Cola de visitas de los nodos adyacentes
			ArrayList<Integer> cola = new ArrayList<Integer>();
//Se lista el nodo como ya recorrido
			recorridos.add(nodoI);
//Se agrega el nodo a la cola de visitas
			cola.add(nodoI);
//Hasta que visite todos los nodos
			while (!cola.isEmpty()) {
				int j = cola.remove(0); //Se saca el primero nodo de la cola
//Se busca en la matriz que representa el grafo los nodos adyacentes
				for (int i = 0; i < g.length; i++) {
//Si es un nodo adyacente y no está visitado entonces
					if (g[j][i] == 1 && !visitiadoAnchura[i]) {
						cola.add(i);//Se agrega a la cola de visitas
						recorridos.add(i);//Se marca como recorrido
						visitiadoAnchura[i] = true;//Se marca como visitado
					}
				}
			}
			return recorridos;//Devuelvo el recorrido del grafo en anchura
		}

		public static void main(String[] args) {
			// TODO code application logic here
			Amplitud g = new Amplitud();
			ArrayList<Integer> enAnchura = g.recorridoAnchura(0);//Nodo inicial 0
			System.out.println("Recorrido en amplitud de un grafo representado como matriz: ");
			for (int i = 0; i < enAnchura.size(); i++) {
				System.out.print("" + enAnchura.get(i) + " ");
			}

		}

	}