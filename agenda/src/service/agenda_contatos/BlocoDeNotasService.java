package service.agenda_contatos;

import model.Notas;

import java.util.ArrayList;
import java.util.List;

public class BlocoDeNotasService {
    private List<Notas> notas = new ArrayList<Notas>();

    public void criarNota(Notas nota) {
        try {
            notas.add(nota);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar a nota: " + e.getMessage());
        }
    }

    public boolean excluirNota(String titulo) {
        boolean notaEncontrada = false;

        if (!notas.isEmpty()) {
            for (int i = 0; i < notas.size(); i++) {
                if (titulo.equals(notas.get(i).getTitulo())) {
                    notas.remove(i);
                    notaEncontrada = true;
                    break;
                }
            }
        }
        return notaEncontrada;
    }

    public List<Notas> getNotas() {
        return notas;
    }
}