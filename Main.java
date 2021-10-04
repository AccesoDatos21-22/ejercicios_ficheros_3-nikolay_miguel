import dao.PokemonDAOImp;

public class Main {
	
	public static void main(String[] args) {
		PokemonDAOImp ejer = new PokemonDAOImp();
		ejer.escribirPokemon("fichero.txt","pikachu",3,4,5,5,5,4);
		

	}

}
