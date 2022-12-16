import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Pessoa {
    private String nome;
    String data;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dataNascimento;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
}
