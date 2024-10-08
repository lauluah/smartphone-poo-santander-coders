//Classe responsável por gerenciar o menu principal de delivery
//Herda da classe Menu e implementa o metodo do 'selecionaOpcao' para exibir e processar as opções do menu de delivery

package menu;

import model.Delivery;
import service.delivery.SubmenuService;
import util.Util;

import java.util.List;

public class MenuDelivery extends Menu {

    @Override
    public void selecionaOpcao() {
        String menu = Menu.geraMenuComOpcoes("MENU DELIVERY", List.of("Pizzas", "Lanches", "Doces", "Bebidas", "Voltar"));

        int opcaoSelecionada;
        do {
            System.out.println(menu);
            opcaoSelecionada = entrada.nextInt();
            switch (opcaoSelecionada) {
                case 1:
                    SubmenuService.exibirSubmenu("Pizzas", List.of(
                            new Delivery("Moda da casa", 60.00),
                            new Delivery("Frango com catupiry", 55.00),
                            new Delivery("Marguerita", 50.00)
                    ));
                    break;

                case 2:
                    SubmenuService.exibirSubmenu("Hamburguer", List.of(
                            new Delivery("Smash com fritas", 38.00),
                            new Delivery("Frango com salada", 32.00),
                            new Delivery("Vegetariano (burguer de soja)", 34.00)
                    ));
                    break;

                case 3:
                    SubmenuService.exibirSubmenu("Doces", List.of(
                            new Delivery("Bolo de cenoura", 8.00),
                            new Delivery("Pão de mel", 6.00),
                            new Delivery("Donuts de chocolate", 12.00)
                    ));
                    break;

                case 4:
                    SubmenuService.exibirSubmenu("Bebidas", List.of(
                            new Delivery("Coca-Cola", 5.00),
                            new Delivery("Suco de Laranja", 7.00),
                            new Delivery("Água Mineral", 3.00)
                    ));
                    break;

                case 5:
                    return;

                default:
                    Util.erro("Opção inválida!");
                    break;
            }
        } while (true);
    }
}