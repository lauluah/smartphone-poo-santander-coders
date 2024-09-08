package util;

import model.Notas;
import service.agenda_contatos.BlocoDeNotasService;
import view.BlocoDeNotas;

import java.util.Scanner;

public class Util {

    public static void escrever(String mensagem) {
        System.out.println(mensagem);
    }

    public static void erro(String mensagem) {
        System.err.println(mensagem);
    }

    public static String ler(Scanner entrada, String questao) {
        System.out.println(questao);
        return entrada.nextLine();
    }

    public static String validarString(Scanner scanner, String pergunta) {
        StringBuilder substr = new StringBuilder();
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine();
            for (int i = 0; i < resposta.length(); i++) {
                char letra = resposta.charAt(i);
                if (letra >= 'A' && letra <= 'Z' || letra >= 'a' && letra <= 'z') {
                    substr.append(letra);
                    if (substr.length() == resposta.length()) {
                        return resposta;
                    }
                } else {
                    System.err.println("Digite um dado textual válido");
                    break;
                }
            }
        }
    }

    public static String validarNumero(Scanner scanner, String pergunta) {
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine();
            try {
                Integer.parseInt(resposta);
                return resposta;
            } catch (NumberFormatException e) {
                System.err.println("Digite um número válido");
            }
        }
    }

    public static String validarEmail(Scanner scanner, String pergunta) {
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine();
            if (resposta.contains("@")) {
                return resposta;
            } else {
                System.err.println("Digite um email válido");
            }
        }
    }

    public static String validarTitulo(Scanner scanner, String pergunta, BlocoDeNotasService blocoDeNotasService) {
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine();

            if (resposta.length() > 12) {
                System.out.println("O título não pode ter mais de 12 caracteres. Tente novamente.");
            } else if (resposta.isEmpty()) {
                System.out.println("O título não pode estar vazio. Tente novamente.");
            } else if (tituloExiste(resposta, blocoDeNotasService)) {
                System.out.println("Esse título já existe. Tente um título diferente.");
            } else {
                return resposta;
            }
        }
    }

    private static boolean tituloExiste(String titulo, BlocoDeNotasService blocoDeNotasService) {
        for (Notas nota : blocoDeNotasService.getNotas()) {
            if (nota.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public static String validarDescricao(Scanner scanner, String pergunta) {
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine();

            if (resposta.length() > 40) {
                System.out.println("A descrição não pode ter mais de 40 caracteres. Tente novamente.");
            } else {
                return resposta;
            }
        }
    }
}