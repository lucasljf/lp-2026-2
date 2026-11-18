package exemplo1;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Aluno a = new Aluno("Professor", "987654");

        a.salvar();
        System.out.println(a.getId());
        
        List<Aluno> alunos = Aluno.listarAlunos();

        for (Aluno aluno : alunos) {
            System.out.println(aluno.getId());
            System.out.println(aluno.getNome());
        }
        
        Aluno b = Aluno.pesquisarMatricula("123456");
        System.out.println(b.getNome());
    }
}
