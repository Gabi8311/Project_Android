package Entidades;

import java.util.ArrayList;
import java.util.Arrays;

public class Rellenar_carta {

    public static ArrayList<ArrayList> rellenar() {

         ArrayList<Plato> platos_Alfredos;
         ArrayList<Plato> platos_Babel;
         ArrayList<Plato> platos_Orecanto;
         ArrayList<Plato> platos_Pulcinella;
         ArrayList<Plato> platos_Sushita;
         ArrayList<ArrayList> all_dishes;

        Plato p1 = new Plato(1, "Hamburguesa BBQ", "Con nuestra salsa BBQ", 12, 5, "Alfredo´s");
        Plato p2 = new Plato(2, "Hamburguesa PHILADELPHIA", "Queso Philadelphia y cebolla a la parrilla", 13, 6, "Alfredo´s");
        Plato p3 = new Plato(3, "Hamburguesa CHILI", "Chile con carne", 9, 4, "Alfredo´s");
        Plato p4 = new Plato(4, "Hamburguesa BTL O QLT", "Bacon, lechuga, tomate y mayonesa", 17, 8, "Alfredo´s");
        Plato p5 = new Plato(5, "Hamburguesa BROOKLYN", "Mozzarella, aceite de oliva virgen extra y orégano", 17, 8, "Alfredo´s");
        Plato p6 = new Plato(6, "Hamburguesa KEFTA", "Con especias marroquíes y ensalada de picadillo", 9, 6, "Alfredo´s");
        Plato p7 = new Plato(7, "Hamburguesa SOUTHERN JACK", "Con especias del sudoeste, queso Monterrey Jack, pimiento frito y cebolla", 18, 9, "Alfredo´s");
        Plato p8 = new Plato(8, "Hamburguesa CLASSIC", "Queso, bacon y nuestra salsa BBQ", 18, 7, "Alfredo´s");
        Plato p9 = new Plato(9, "Hamburguesa GOAT", "Queso de cabra y cebolla caramelizada", 19, 8, "Alfredo´s");
        Plato p10 = new Plato(10, "Hamburguesa VEGGIE", "Nuestra excepción para vegetarianos experimentados", 15, 8, "Alfredo´s");

        platos_Alfredos = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));


        Plato p11 = new Plato(11, "Croquetas con chipirones", "Con aguacate, pepinillo y papaya", 14, 6, "Babel");
        Plato p12 = new Plato(12, "Huevos rotos", "A baja temperatura al aroma de trufa blanca con crujiente jamón", 10, 6, "Babel");
        Plato p13 = new Plato(13, "Poke de salmón", "Chile con carne", 9, 4, "Babel");
        Plato p14 = new Plato(14, "Arroz a banda", "(Para 2 personas)Precio por persona", 10, 10, "Babel");
        Plato p15 = new Plato(15, "Hamburguesa de picada de vaca", "Madurada con idiazabál y mahonesa de albahaca", 14, 8, "Babel");
        Plato p16 = new Plato(16, "Bao de pollo", "Con pollo y shitake", 5, 4, "Babel");
        Plato p17 = new Plato(17, "Bao de costillas", "Con costillas desmijadas estilo cajún", 6, 6, "Babel");
        Plato p18 = new Plato(18, "Jarrete de ternera", "Asado a baja temperatura con kimchee ahumado y patatas al tomillo", 18, 7, "Babel");
        Plato p19 = new Plato(19, "Dados de carrillera ibérica", "Con cous cous de verduras", 14, 9, "Babel");
        Plato p20 = new Plato(20, "Tiradito de atún rojo", "Con coulis de ají amarillo y naranja", 18, 8, "Babel");

        platos_Babel = new ArrayList<>(Arrays.asList(p11, p12, p13, p14, p15, p16, p17, p18, p19, p20));


        Plato p21 = new Plato(21, "Rabo de toro", "De los mejores del mundo", 17, 8, "O´recanto");
        Plato p22 = new Plato(22, "Callos con garbanzos", "Te faltará pan para todo lo que vas a desear mojar en ellos", 17, 9, "O´recanto");
        Plato p23 = new Plato(23, "Manitas de cerdo", "Preparadas por los especialistas más codiciados en este sagrado manjar", 14, 10, "O´recanto");
        Plato p24 = new Plato(24, "Mariscada cocida", "Gran mariscada para 2 personas mínimo", 85, 10, "O´recanto");
        Plato p25 = new Plato(25, "Cigala de tronco", "El precio corresponde a cada Kg", 165, 8, "O´recanto");
        Plato p26 = new Plato(26, "Solomillo O´grelo", "La más deliciosa carne que puedas encontrar.Gallega 100%", 55, 8, "O´recanto");
        Plato p27 = new Plato(27, "Entrecot de ternera gallega", "Una de nuestras especialidades.Uno de los platos que nos ha hecho famosos", 21, 7, "O´recanto");
        Plato p28 = new Plato(28, "Chuletón de vaca gallegaa", "La mejor carne que puedas encontrar.Si encuentra algo mejor le devolvemos el dinero", 59, 8, "O´recanto");
        Plato p29 = new Plato(29, "Steak tartere rubia gallega", "Auténtica ambrosía de los dioses", 25, 9, "O´recanto");
        Plato p30 = new Plato(30, "Bogavante", "El precio por cada Kg", 80, 8, "O´recanto");

        platos_Orecanto = new ArrayList<>(Arrays.asList(p21, p22, p23, p24, p25, p26, p27, p28, p29, p30));


        Plato p31 = new Plato(31, "Paccheri con bogavante", "Con un toque de tomate San Marzano y guindilla", 24, 8, "Pulcinella");
        Plato p32 = new Plato(32, "Spaghetti Nerano", "Con calabacín.Provolone del Monaco, parmesano y pimienta negra", 13, 8, "Pulcinella");
        Plato p33 = new Plato(33, "Delizia marí", "Rellena de ricotta y espinacas con crema de pesto de pistacho", 15, 9, "Pulcinella");
        Plato p34 = new Plato(34, "Pollo alla cacciatora", "Pechuga de pollo con salsa de tomate,champiñones, acompañados de puré de patata trufado", 12, 10, "Pulcinella");
        Plato p35 = new Plato(35, "Scaloppine al Marsala", "Filetes de ternera blanca al vino Marsala, romero y guindilla", 16, 8, "Pulcinella");
        Plato p36 = new Plato(36, "Tagliata di Manzo", "Solomillo con salsa de boletus y trufa fresca, acompañado de puré trufado de patata", 20, 8, "Pulcinella");
        Plato p37 = new Plato(37, "Rigatoni all'indiavolata", "Con champiñones, panceta italiana, mozzarella y guindilla en nuestra salsa de tomate San Marzano", 14, 7, "Pulcinella");
        Plato p38 = new Plato(38, "Spaghetti alla carbonara", "Preparados según la receta original, con yema de huevo, parmesano,panceta italiana y pimienta negra", 12, 8, "Pulcinella");
        Plato p39 = new Plato(39, "Pennette salmone e vodka", "Con salmón fresco, cebolla, nata y un toque de vodka", 18, 7, "Pulcinella");
        Plato p40 = new Plato(40, "Lasagna emiliana", "Con salsa de tomate San Marzano con ternera picada y bechamel", 18, 10, "Pulcinella");

        platos_Pulcinella = new ArrayList<Plato>(Arrays.asList(p31, p32, p33, p34, p35, p36, p37, p38, p39, p40));


        Plato p41 = new Plato(41, "Rollitos de pato", "Los mejores rollitos del mundo.Relleno de carne de pato", 9, 6, "Sushita");
        Plato p42 = new Plato(42, "Croquetas de atún Katsoubushi", "Uno de nuestros más pedidos por nuestros comensales", 8, 5, "Sushita");
        Plato p43 = new Plato(43, "Rollo tartar de atún picante", "Con atún rojo de máxima calidad y un ligero tono picante", 12, 9, "Sushita");
        Plato p44 = new Plato(44, "California especial", "Maki especial con sémola alrededor, relleno de gamba y quinoa", 12, 10, "Sushita");
        Plato p45 = new Plato(45, "Solomillo con salsa teriyaki", "Carne de máxima calidad con nuestra famosa salsa", 18, 8, "Sushita");
        Plato p46 = new Plato(46, "Mien con trufa, setas y huevo escalfado", "Una de nuestras especialidades.Con un suave sabor a trufa y huevo", 16, 8, "Sushita");
        Plato p47 = new Plato(47, "Pizza crujiente de aguacate con huevo", "Con un suave toque a aguacate y huevo.Súper crujiente", 14, 7, "Sushita");
        Plato p48 = new Plato(48, "Lubina al vapor marinada", "Hecha por las mejores manos de nuestro restaurante", 12, 8, "Sushita");
        Plato p49 = new Plato(49, "Costillas de ternera al josper con salsa picante", "Nuestro nivel de picante es un poco alto.Para estómagos fuertes", 16, 9, "Sushita");
        Plato p50 = new Plato(50, "Arroz frito con confit de pato", "Es una delicia,juntando dos de nuestros platos estrella", 11, 8, "Sushita");

        platos_Sushita = new ArrayList<>(Arrays.asList(p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

        all_dishes = new ArrayList<>(Arrays.asList(platos_Alfredos, platos_Babel, platos_Orecanto, platos_Pulcinella, platos_Sushita));

        return all_dishes;

    }

}
