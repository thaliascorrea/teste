import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Principal {
    public static void main(String[] args) {
        Funcionario f1, f2, f3, f4, f5, f6, f7, f8, f9, f10;
        LocalDate hoje = LocalDate.now();
        int maiorIdade = 0;
        String nomeMaiorIdade = "";
        BigDecimal somaSalarios = BigDecimal.valueOf(0);
        double salMinimo = 1212.00;
        double qtdSalMinimo = 0.0;
        
        //3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        List<Funcionario> list = new ArrayList<>();
        list.add(f1 = new Funcionario("Maria", "18/10/2000", BigDecimal.valueOf(2009.44), "Operador"));
        list.add(f2 = new Funcionario("João", "12/05/1990", BigDecimal.valueOf(2284.38), "Operador"));
        list.add(f3 = new Funcionario("Caio", "02/05/1961", BigDecimal.valueOf(9836.14), "Coordenador"));
        list.add(f4 = new Funcionario("Miguel", "14/10/1988", BigDecimal.valueOf(19119.88), "Diretor"));
        list.add(f5 = new Funcionario("Alice", "05/01/1995", BigDecimal.valueOf(2234.68), "Recepcionista"));
        list.add(f6 = new Funcionario("Heitor", "19/11/1999", BigDecimal.valueOf(1582.72), "Operador"));
        list.add(f7 = new Funcionario("Arthur", "31/03/1993", BigDecimal.valueOf(4071.84), "Contador"));
        list.add(f8 = new Funcionario("Laura", "08/07/1994", BigDecimal.valueOf(3017.45), "Gerente"));
        list.add(f9 = new Funcionario("Heloísa", "24/05/2003", BigDecimal.valueOf(1606.85), "Eletricista"));
        list.add(f10 = new Funcionario("Helena", "02/09/1996", BigDecimal.valueOf(2799.93), "Gerente"));
        
        //3.2 - Remover o funcionário “João” da lista.
        list.remove(f2);
        
        //3.3 - Imprimir todos os funcionários com todas suas informações, sendo que:
        //• informação de data deve ser exibido no formato dd/mm/aaaa;
        //• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        System.out.println("3.3 - Lista dos funcionários com todas as informações:");
        for (Funcionario f : list){
            System.out.println(f);
        }
        
        //3.4 - Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        for (Funcionario f : list){
            f.aumento(f.getSalario());    
        }
        System.out.println("");
        System.out.println("3.4 - Atualização da lista de funcionários após o aumento de 10%:");
        for (Funcionario f : list){
            System.out.println(f);
        }
        System.out.println("");
        
        //3.5 - Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, HashSet<Funcionario>> func = new HashMap<String, HashSet<Funcionario>>();
        func.put("Operador", new HashSet());
        func.put("Coordenador", new HashSet());
        func.put("Diretor", new HashSet());
        func.put("Recepcionista", new HashSet());
        func.put("Contador", new HashSet());
        func.put("Gerente", new HashSet());        
        func.put("Eletricista", new HashSet());
        func.put("Operador", new HashSet());
        
        for(String key : func.keySet()){
            for (Funcionario f : list){
                if (f.getFuncao().equals(key)){
                    func.get(key).add(f);
                }
            }   
        }
        
        //3.6 - Imprimir os funcionários, agrupados por função.
        System.out.println("");
        System.out.println("3.6 - Lista de funcionários agrupados por função:");
        for (String key : func.keySet()){
            System.out.println(key);
            System.out.println(func.get(key));
        }
        
        //3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("");
        System.out.println("3.8 - Aniversariantes do mês de outubro e dezembro:");
        for (Funcionario f : list){
            if (f.dataNascimento.getMonthValue() == 10 || f.dataNascimento.getMonthValue() == 12){
                System.out.println(f.getNome());
            }
        }
        
        //3.9 - Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("");
        for (Funcionario f : list){
            f.setIdade(hoje.getYear() - f.dataNascimento.getYear());
            if (f.getIdade() > maiorIdade){
                maiorIdade = f.getIdade();
                nomeMaiorIdade = f.getNome();
            }
        }
        System.out.println("3.9 - O funcionário com maior idade é: " + nomeMaiorIdade + " com " + maiorIdade + " anos.");
        System.out.println("");
        
        //3.10 - Imprimir a lista de funcionários por ordem alfabética.
        Map<String, Funcionario> funcLista = new TreeMap<>();
        funcLista.put("Maria", f1);
        funcLista.put("Caio", f3);
        funcLista.put("Miguel", f4);
        funcLista.put("Alice", f5);
        funcLista.put("Heitor", f6);
        funcLista.put("Arthur", f7);
        funcLista.put("Laura", f8);
        funcLista.put("Heloísa", f9);
        funcLista.put("Helena", f10);
        System.out.println("3.10 - Lista de funcionários por ordem alfabética:");
        for (String key : funcLista.keySet()){
            System.out.println(funcLista.get(key));
        }
        
        //3.11 - Imprimir o total dos salários dos funcionários.
        System.out.println("");
        for (Funcionario f : list){
            somaSalarios = somaSalarios.add(f.getSalario());
        }
        DecimalFormat df = new DecimalFormat("R$ #,###.00");
        System.out.println("3.11 - A soma dos salários dos funcionários é: " + df.format(somaSalarios));
        System.out.println("");
        //3.12 - Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("3.12 - Lista de salários mínimos por funcionário:");
        for (Funcionario f : list){
            qtdSalMinimo = f.getSalario().doubleValue()/salMinimo;
            System.out.println("O funcionário " + f.getNome() + " recebe " + String.format("%.2f", qtdSalMinimo) + " salários mínimos.");
        }
    }   
}
