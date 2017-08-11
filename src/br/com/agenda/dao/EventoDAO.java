package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.agenda.modelo.Evento;
import br.com.agenda.util.ConnectionFactory;

public class EventoDAO {

	public void salvar(Evento evento) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO agenda.evento (titulo_evento, inicio_evento, fim_evento, ");
		sql.append("desc_evento, status_evento) VALUES (?,?,?,?,?);");
		Connection conexao = ConnectionFactory.conectar();
		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, evento.getTitutloEvento());
			comando.setDate(2, (Date) evento.getInicioEvento());
			comando.setDate(3, (Date) evento.getFimEvento());
			comando.setString(4, evento.getDescEvento());
			comando.setBoolean(5, evento.getStatusEvento());
			comando.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Falha ao salvar o evento!");
			e.printStackTrace();
		}
		ConnectionFactory.desconectar(conexao);
	}

	public void editar(Evento evento) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE agenda.evento SET titulo.evento=?, inicio_evento=?, fim_evento=?, ");
		sql.append("desc_evento=?, WHERE id_evento=?;");
		Connection conexao = ConnectionFactory.conectar();
		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, evento.getTitutloEvento());
			comando.setDate(2, (Date) evento.getInicioEvento());
			comando.setDate(3, (Date) evento.getFimEvento());
			comando.setString(4, evento.getDescEvento());
			comando.setLong(5, evento.getIdEvento());
			comando.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Falha ao editar o evento!");
			e.printStackTrace();
		}
	}

	public void excluir(Evento evento) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM agenda.evento ");
		sql.append("WHERE id_evento = ?;");
		Connection conexao = ConnectionFactory.conectar();
		try {
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setLong(1, evento.getIdEvento());
			comando.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Falha ao excluir o evento!");
			e.printStackTrace();
		}
		ConnectionFactory.desconectar(conexao);
	}

}
