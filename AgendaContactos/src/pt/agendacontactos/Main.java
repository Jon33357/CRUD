package pt.agendacontactos;
import java.sql.Date;
import java.util.Scanner;

public class Main {

	private static Scanner _scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		int option = -1;
		while(option != 0)
		{

			System.out.println("===========MENU ALUNOS==========");
			System.out.println("1 => Inserir");
			System.out.println("2 => Listar");
			System.out.println("3 => Atualizar");
			System.out.println("4 => Eliminar");
			System.out.println("5 => Pesquisar por id");
			System.out.println("6 => Pesquisar por nome");
			System.out.println("0 => Sair");
			System.out.println("================================");
			System.out.print("Escolha uma opção: ");
			option = _scanner.nextInt();

			switch(option)
			{
			case 1: 
				System.out.println("====INSERIR ALUNO====");
				inserir();
				break;
			case 2:
				System.out.println("====LISTAR ALUNOS====");
				listar();
				break;
			case 3:
				System.out.println("====ATUALIZAR ALUNOS====");
				atualizar();
				break;
			case 4:
				System.out.println("====EXCLUIR ALUNOS====");
				eliminar();
				break;
			case 5:
				System.out.println("====PESQUISAR POR NÃšMERO PROCESSO====");
				pesquisarId();
				break;
			case 6:
				System.out.println("====PESQUISAR POR NOME====");
				pesquisarNome();
				break;
			case 0:
				System.out.println("Sair do programa...");
				break;
			default:
				System.out.println("Opção Inválida. Escolha outra opção");
			}
		}
		
		_scanner.close();
	}
	
	
    public static void inserir()
    {
        System.out.println("Insere o nome: ");
        String nome = _scanner.nextLine();
        System.out.println("Insere o e-mail: ");
        String email = _scanner.nextLine();
        System.out.println("Insere o telemovel: ");
        int idade = _scanner.nextInt();
        System.out.println("Insere a data nascimento(YYYY-MM-DD): ");
        String dataNasc = _scanner.nextLine();
        try{
            Date data = Date.valueOf(dataNasc);
            Contact a = new Contact();
            a.setNome(nome);
            a.setEmail(email);
            a.setData_aniv(data);
            a.setTele(idade);
            ContactDAO dao = new ContactDAO();
            dao.InsertContact(a);
        }catch (IllegalArgumentException ex) {
            System.out.println("Erro na data: "+ ex);
        }
    }
    
    
    public static void listar()
    {
    	ContactDAO dao = new ContactDAO();
        for(Contact c: dao.ListContacts())
        {
            System.out.println("Id: "+c.getId());
            System.out.println("Nome: "+c.getNome());
            System.out.println("Email: "+c.getEmail());
            System.out.println("Telemoel: "+c.getTele());
            System.out.println("Data de nascimento: "+c.getData_aniv());
            System.out.println("------------------------");
        }
    }
    
    
    public static void atualizar()
    {
        Contact c = null;
        System.out.println("Insere o id que pretende atualizar");
        int num = _scanner.nextInt();
        ContactDAO dao = new ContactDAO();
        c = dao.SearchById(num);
        if(c == null)
        {
            System.out.println("O contacto não existe na base de dados");
        }
        else
        {
            System.out.println("Id: "+c.getId());
            System.out.println("Nome: "+c.getNome());
            System.out.println("Email: "+c.getEmail());
            System.out.println("Telefone: "+c.getTele());
            System.out.println("Data de nascimento: "+c.getData_aniv());
            System.out.println("------------------------");
            System.out.println("Atualizar os dados do Contacto - "+num);
            System.out.println("Atualiza o nome: ");
            String nome =  _scanner.nextLine();
            System.out.println("Atualiza o e-mail: ");
            String email =  _scanner.nextLine();
            System.out.println("Atualiza o telemovel: ");
            int idade =  _scanner.nextInt();
            System.out.println("Atualiza a data nascimento(YYYY-MM-DD): ");
            String dataNasc =  _scanner.nextLine();
            try{
                Date data = Date.valueOf(dataNasc);
                c.setNome(nome);
                c.setEmail(email);
                c.setTele(idade);
                c.setData_aniv(data);
                dao.Update(c);
            }catch (IllegalArgumentException ex) {
                System.out.println("Erro na data: "+ex);
            }
        }
    }
    
    public static void eliminar()
    {
        System.out.println("Insere o id que pretende eliminar");
        int num = _scanner.nextInt();
        ContactDAO dao = new ContactDAO();
        Contact c = dao.SearchById(num);
        if(c == null)
        {
            System.out.println("O contacto não existe na base de dados");
        }
        else
        {
            System.out.println("id: "+c.getId());
            System.out.println("Nome: "+c.getNome());
            System.out.println("Email: "+c.getEmail());
            System.out.println("Telemovel: "+c.getTele());
            System.out.println("Data de nascimento: "+c.getData_aniv());
            System.out.println("------------------------");
            System.out.println("Eliminar os dados do contacto com o id - "+ num);
            dao.Delete(num);
        }
    }
    
    public static void pesquisarId()
    {
        System.out.println("Insere o id que pretende pesquisar");
        int num = _scanner.nextInt();
        ContactDAO dao = new ContactDAO();
        Contact c = dao.SearchById(num);
        if(c == null)
        {
            System.out.println("O contacto não existe na base de dados");
        }
        else
        {
            System.out.println("id: "+c.getId());
            System.out.println("Nome: "+c.getNome());
            System.out.println("Email: "+c.getEmail());
            System.out.println("Telemovel: "+c.getTele());
            System.out.println("Data de nascimento: "+c.getData_aniv());
        }
    }
    
    public static void pesquisarNome()
    {
        System.out.println("Insere o nome a pesquisar");
        String nome = _scanner.nextLine();
        ContactDAO dao = new ContactDAO();
        Contact c = dao.SearchByName(nome);
        System.out.println("Id: "+c.getId());
        System.out.println("Nome: "+c.getNome());
        System.out.println("Email: "+c.getEmail());
        System.out.println("Telemovel: "+c.getTele());
        System.out.println("Data de nascimento: "+c.getData_aniv());
        System.out.println("------------------------");

    }
}
