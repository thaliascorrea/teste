import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;
    private int idade;
    
    public Funcionario(String nome, String data, BigDecimal salario, String funcao) {
        this.setNome(nome);
        this.dataNascimento = LocalDate.parse(data, formatter);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("R$ #,###.00");

        return "Nome: " + getNome() + ", data de nascimento: " + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ", salário: " + df.format(salario) + ", função: " + funcao + ".";
                
    }
    
    public void aumento(BigDecimal salario){
        BigDecimal aumento = new BigDecimal("0.10");
        this.salario = salario.add(salario.multiply(aumento));
    }
}
