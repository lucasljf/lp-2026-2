package exemplo1;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Aluno a = new Aluno("Lucas", "100000");

        a.salvar();

        List<Aluno> alunos = a.listarAlunos();

        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }
}
