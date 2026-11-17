package exemplo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public String getNome() {
        return nome;
    }

    public void salvar() {
        String sql = "INSERT INTO aluno (nome, matricula) VALUES (?, ?)";

        try {
            Connection conexao = new Conexao().getConexao();
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

    public List<Aluno> listarAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";

        try {
            Connection conexao = new Conexao().getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql);

            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String matricula = resultado.getString("matricula");

                Aluno a = new Aluno(id, nome, matricula);
                alunos.add(a);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return alunos;
    }
}
