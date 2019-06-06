package lab5b;

public class Data {
    private String dia;
    private String mes;
    private String ano;

    public Data(String d){
        String[] temp = d.split("/");
        if(temp.length > 3 || temp.length < 3) throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
        if(temp[0].length() > 2 || temp[0].length() < 2) throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
        if(temp[1].length() > 2 || temp[1].length() < 2) throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
        if(temp[2].length() > 4 || temp[2].length() < 4) throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
        this.dia = temp[0];
        this.mes = temp[1];
        this.ano = temp[2];
    }
    @Override
    public String toString(){
        return this.dia + "-" + this.mes + "-" + this.ano;
    }
}
