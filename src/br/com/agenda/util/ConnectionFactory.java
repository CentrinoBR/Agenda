package br.com.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String USUARIO = "postgres";
	private static final String SENHA = "123456";
	private static final String URL = "jdbc:postgresql://localhost:5432/controle";
	private static final String DRIVER = "org.postgresql.Driver";

	/** Método para conexão com o banco
	 * 
	 * @return
	 */
	public static Connection conectar() {

		Connection conexao = null;

		try {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				System.out.println("Erro no carregamento do driver!");
				e.printStackTrace();
			}
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar ao banco!");
			e.printStackTrace();
		}

		return conexao;
		
	}
	
	public static void desconectar (Connection conexao) {
		
		try {
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro ao desconectar do banco!");
			e.printStackTrace();
		}
	}
	
}
