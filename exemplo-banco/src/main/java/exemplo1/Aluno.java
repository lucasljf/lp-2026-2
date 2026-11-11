package exemplo1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Aluno {

    private int id;
    private String nome;
    private String matricula;

    public Aluno(int id, String nome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Aluno(String nome, String matricula) {
        this.id = 0;
        this.nome = nome;
        this.matricula = matricula;
    }

    public void salvar() {
        Connection conexao = new Conexao().getConexao();
        
        String sql = "INSERT INTO aluno (nome, matricula) VALUES (?, ?)";
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, this.nome);
            comando.setString(2, this.matricula);
            comando.execute();
            comando.close();
            
            conexao.close();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
