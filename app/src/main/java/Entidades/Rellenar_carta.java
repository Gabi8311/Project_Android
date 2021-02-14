package Entidades;

import com.example.android_project.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Rellenar_carta {

    public static ArrayList<ArrayList> rellenar() {

        ArrayList<Plato> platos_Alfredos;
        ArrayList<Plato> platos_Babel;
        ArrayList<Plato> platos_Orecanto;
        ArrayList<Plato> platos_Pulcinella;
        ArrayList<Plato> platos_Sushita;
        ArrayList<Plato> platos_Trattoria;
        ArrayList<Plato> platos_El_Asador;
        ArrayList<Plato> platos_Tio_Paco;
        ArrayList<Plato> platos_Gourmet;
        ArrayList<Plato> platos_Minotauro;
        ArrayList<ArrayList> all_dishes;

        Plato p1 = new Plato(1, "Hamburguesa BBQ", "Con nuestra salsa BBQ", 12, 5, "Alfredo´s", "bbq");
        Plato p2 = new Plato(2, "Hamburguesa PHILADELPHIA", "Queso Philadelphia y cebolla a la parrilla", 13, 6, "Alfredo´s", "philadelphia");
        Plato p3 = new Plato(3, "Hamburguesa CHILI", "Chile con carne", 9, 4, "Alfredo´s", "chili");
        Plato p4 = new Plato(4, "Hamburguesa BTL O QLT", "Bacon, lechuga, tomate y mayonesa", 17, 8, "Alfredo´s", "btl");
        Plato p5 = new Plato(5, "Hamburguesa BROOKLYN", "Mozzarella, aceite de oliva virgen extra y orégano", 17, 8, "Alfredo´s", "brooklyn");
        Plato p6 = new Plato(6, "Hamburguesa KEFTA", "Con especias marroquíes y ensalada de picadillo", 9, 6, "Alfredo´s", "kefta");
        Plato p7 = new Plato(7, "Hamburguesa SOUTHERN JACK", "Con especias del sudoeste, queso Monterrey Jack, pimiento frito y cebolla", 18, 9, "Alfredo´s", "jack");
        Plato p8 = new Plato(8, "Hamburguesa CLASSIC", "Queso, bacon y nuestra salsa BBQ", 18, 7, "Alfredo´s", "classic");
        Plato p9 = new Plato(9, "Hamburguesa GOAT", "Queso de cabra y cebolla caramelizada", 19, 8, "Alfredo´s", "goat");
        Plato p10 = new Plato(10, "Hamburguesa VEGGIE", "Nuestra excepción para vegetarianos experimentados", 15, 8, "Alfredo´s", "veggie");

        platos_Alfredos = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));


        Plato p11 = new Plato(11, "Croquetas con chipirones", "Con aguacate, pepinillo y papaya", 14, 6, "Babel", "croquetas");
        Plato p12 = new Plato(12, "Huevos rotos", "A baja temperatura al aroma de trufa blanca con crujiente jamón", 10, 6, "Babel", "huevos_rotos");
        Plato p13 = new Plato(13, "Poke de salmón", "El mejor Poke de la zona Norte de Madrid. Disfrútalo!", 9, 4, "Babel", "poke");
        Plato p14 = new Plato(14, "Arroz a banda", "(Para 2 personas)Precio por persona", 10, 10, "Babel", "arroz_banda");
        Plato p15 = new Plato(15, "Hamburguesa de picada de vaca", "Madurada con idiazabál y mahonesa de albahaca", 14, 8, "Babel", "picada");
        Plato p16 = new Plato(16, "Bao de pollo", "Con pollo y shitake", 5, 4, "Babel", "bao2");
        Plato p17 = new Plato(17, "Bao de costillas", "Con costillas desmijadas estilo cajún", 6, 6, "Babel", "bao");
        Plato p18 = new Plato(18, "Jarrete de ternera", "Asado a baja temperatura con kimchee ahumado y patatas al tomillo", 18, 7, "Babel", "jarrete");
        Plato p19 = new Plato(19, "Dados de carrillera ibérica", "Con cous cous de verduras", 14, 9, "Babel", "dados");
        Plato p20 = new Plato(20, "Tiradito de atún rojo", "Con coulis de ají amarillo y naranja", 18, 8, "Babel", "atun_rojo");

        platos_Babel = new ArrayList<>(Arrays.asList(p11, p12, p13, p14, p15, p16, p17, p18, p19, p20));


        Plato p21 = new Plato(21, "Rabo de toro", "De los mejores del mundo", 17, 8, "O´recanto", "rabo");
        Plato p22 = new Plato(22, "Callos con garbanzos", "Te faltará pan para todo lo que vas a desear mojar en ellos", 17, 9, "O´recanto", "callos");
        Plato p23 = new Plato(23, "Manitas de cerdo", "Preparadas por los especialistas más codiciados en este sagrado manjar", 14, 10, "O´recanto", "manitas");
        Plato p24 = new Plato(24, "Mariscada cocida", "Gran mariscada para 2 personas mínimo", 85, 10, "O´recanto", "mariscada");
        Plato p25 = new Plato(25, "Cigala de tronco", "El precio corresponde a cada Kg", 165, 8, "O´recanto", "cigala");
        Plato p26 = new Plato(26, "Solomillo O´grelo", "La más deliciosa carne que puedas encontrar.Gallega 100%", 55, 8, "O´recanto", "solomillo");
        Plato p27 = new Plato(27, "Entrecot de ternera gallega", "Una de nuestras especialidades.Uno de los platos que nos ha hecho famosos", 21, 7, "O´recanto", "entrecot");
        Plato p28 = new Plato(28, "Chuletón de vaca gallegaa", "La mejor carne que puedas encontrar.Si encuentra algo mejor le devolvemos el dinero", 59, 8, "O´recanto", "chuleton");
        Plato p29 = new Plato(29, "Steak tartere rubia gallega", "Auténtica ambrosía de los dioses", 25, 9, "O´recanto", "tartar");
        Plato p30 = new Plato(30, "Bogavante", "El precio por cada Kg", 80, 8, "O´recanto", "bogavante");

        platos_Orecanto = new ArrayList<>(Arrays.asList(p21, p22, p23, p24, p25, p26, p27, p28, p29, p30));


        Plato p31 = new Plato(31, "Paccheri con bogavante", "Con un toque de tomate San Marzano y guindilla", 24, 8, "Pulcinella", "paccheri");
        Plato p32 = new Plato(32, "Spaghetti Nerano", "Con calabacín.Provolone del Monaco, parmesano y pimienta negra", 13, 8, "Pulcinella", "nerano");
        Plato p33 = new Plato(33, "Delizia marí", "Rellena de ricotta y espinacas con crema de pesto de pistacho", 15, 9, "Pulcinella", "delizia");
        Plato p34 = new Plato(34, "Pollo alla cacciatora", "Pechuga de pollo con salsa de tomate,champiñones, acompañados de puré de patata trufado", 12, 10, "Pulcinella", "caccitor");
        Plato p35 = new Plato(35, "Scaloppine al Marsala", "Filetes de ternera blanca al vino Marsala, romero y guindilla", 16, 8, "Pulcinella", "scaloppine");
        Plato p36 = new Plato(36, "Tagliata di Manzo", "Solomillo con salsa de boletus y trufa fresca, acompañado de puré trufado de patata", 20, 8, "Pulcinella", "tagliata");
        Plato p37 = new Plato(37, "Rigatoni all'indiavolata", "Con champiñones, panceta italiana, mozzarella y guindilla en nuestra salsa de tomate San Marzano", 14, 7, "Pulcinella", "rigatoni");
        Plato p38 = new Plato(38, "Spaghetti alla carbonara", "Preparados según la receta original, con yema de huevo, parmesano,panceta italiana y pimienta negra", 12, 8, "Pulcinella", "carbonara");
        Plato p39 = new Plato(39, "Pennette salmone e vodka", "Con salmón fresco, cebolla, nata y un toque de vodka", 18, 7, "Pulcinella", "penette");
        Plato p40 = new Plato(40, "Lasagna emiliana", "Con salsa de tomate San Marzano con ternera picada y bechamel", 18, 10, "Pulcinella", "lasagna");

        platos_Pulcinella = new ArrayList<Plato>(Arrays.asList(p31, p32, p33, p34, p35, p36, p37, p38, p39, p40));


        Plato p41 = new Plato(41, "Rollitos de pato", "Los mejores rollitos del mundo.Relleno de carne de pato", 9, 6, "Sushita", "rollitos");
        Plato p42 = new Plato(42, "Croquetas de atún Katsoubushi", "Uno de nuestros más pedidos por nuestros comensales", 8, 5, "Sushita", "croquetas_atun");
        Plato p43 = new Plato(43, "Rollo tartar de atún picante", "Con atún rojo de máxima calidad y un ligero tono picante", 12, 9, "Sushita", "tartar_atun");
        Plato p44 = new Plato(44, "California especial", "Maki especial con sémola alrededor, relleno de gamba y quinoa", 12, 10, "Sushita", "california");
        Plato p45 = new Plato(45, "Solomillo con salsa teriyaki", "Carne de máxima calidad con nuestra famosa salsa", 18, 8, "Sushita", "solomillo_teriyaki");
        Plato p46 = new Plato(46, "Mien con trufa, setas y huevo escalfado", "Una de nuestras especialidades.Con un suave sabor a trufa y huevo", 16, 8, "Sushita", "mien");
        Plato p47 = new Plato(47, "Pizza crujiente de aguacate con huevo", "Con un suave toque a aguacate y huevo.Súper crujiente", 14, 7, "Sushita", "crujiente");
        Plato p48 = new Plato(48, "Lubina al vapor marinada", "Hecha por las mejores manos de nuestro restaurante", 12, 8, "Sushita", "lubina");
        Plato p49 = new Plato(49, "Costillas de ternera al josper con salsa picante", "Nuestro nivel de picante es un poco alto.Para estómagos fuertes", 16, 9, "Sushita", "josper");
        Plato p50 = new Plato(50, "Arroz frito con confit de pato", "Es una delicia,juntando dos de nuestros platos estrella", 11, 8, "Sushita", "confit");

        platos_Sushita = new ArrayList<>(Arrays.asList(p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));


        Plato p51 = new Plato(51, "Lasaña Trattoria", "La mejor Lasaña de Italia en tu plato.Carne de máxima calidad", 14, 10, "Trattoria", "lasagna2");
        Plato p52 = new Plato(52, "Macarrones al pesto", "Famosos en todo Madrid.Una de nuestras joyas", 12, 8, "Trattoria", "pesto");
        Plato p53 = new Plato(53, "Spaghetti Bolognesa", "No hay ningunos bolognesa como los nuestros.Te retamos a que encuentres unos mejores", 10, 9, "Trattoria", "bolognesa");
        Plato p54 = new Plato(54, "Spaghetti boletus", "La mejor colaboración entre 2 alimentos.Maravilla pura", 12, 10, "Trattoria", "boletus");
        Plato p55 = new Plato(55, "Pizza con piña", "La mejor adaptación de la odiada piña en la pizza.Pruébala!", 12, 8, "Trattoria", "pizza");
        Plato p56 = new Plato(56, "Gnocchi de gorgonsola", "Con la salsa de tomate casera conocida en todo el mundo", 14, 7, "Trattoria", "gnocchi");
        Plato p57 = new Plato(57, "Scaloppina di pollo", "Filete de pollo empanado gratinados con pomodoro", 13, 6, "Trattoria", "scalopina");
        Plato p58 = new Plato(58, "Solomillo di malale cosa nostra", "Solomillo de cerdo cabreado al estilo cosa nostra", 12, 8, "Trattoria", "cosa_nostra");
        Plato p59 = new Plato(59, "Salmone con croste di senape", "Suprema de salmón con costra de mostaza", 15, 7, "Trattoria", "salmone");
        Plato p60 = new Plato(60, "Tonno rosso alla siciliana", "Lomo de atún rojo a la siciliana", 12, 8, "Trattoria", "rosso");

        platos_Trattoria = new ArrayList<>(Arrays.asList(p51, p52, p53, p54, p55, p56, p57, p58, p59, p60));


        Plato p61 = new Plato(61, "Jamón y Lomo ibérico con Pan y Tomate", "De los mejores cerdos extremeños,tratados mejor que al principe de Zamunda", 16, 6, "El Asador", "jamon_lomo");
        Plato p62 = new Plato(62, "Pimientos rellenos de Marisco con salsa de nécoras", "Calidad suprema en uno de nuestros platos estrella", 21, 9, "El Asador", "pimientos");
        Plato p63 = new Plato(63, "Arroz cremoso de Setas y Hongos trufados", "Preparación al estilo burgalés con la mejor materia prima", 20, 15, "El Asador", "cremoso");
        Plato p64 = new Plato(64, "Tortilla de Bacalao estilo  Sidreria", "Conocida en todo Madrid y ganadora del Trofeo 'Mejor tortilla del Año'", 12, 9, "El Asador", "tortilla_bacalao");
        Plato p65 = new Plato(65, "Solomillo (500g)", "Carne de máxima calidad a la parrilla,con salsa de trufa,", 18, 8, "El Asador", "solomillo2");
        Plato p66 = new Plato(66, "Chuletón de Buey a la parrilla (800g)", "Una de nuestras especialidades,cocinado con la mejor parrilla de Madrid", 22, 8, "El Asador", "chuleton2");
        Plato p67 = new Plato(67, "Filete de ternera blanca", "Máxima calidad de carne.Servido con una salsa de hongos", 14, 7, "El Asador", "blanca");
        Plato p68 = new Plato(68, "Entrecotte de Kilo", "Es una bestialidad,tanto por su calidad como por su tamaño.Una locura", 28, 8, "El Asador", "entrecot");
        Plato p69 = new Plato(69, "Costillas de ternera", "Uno de nuestros mayores caprichos.Nuestra salsa de ajo es la Mejor del mundo,sin duda", 16, 12, "El Asador", "costillas");
        Plato p70 = new Plato(70, "Parrillada de Carne", "Salchichas,chorizo,loganiza,secreto...3Kg de carne de primera calidad", 30, 14, "El Asador", "parrillada");

        platos_El_Asador = new ArrayList<>(Arrays.asList(p61, p62, p63, p64, p65, p66, p67, p68, p69, p70));


        Plato p71 = new Plato(71, "Pastel Templado de centollo y Buey de Mar", "Tiene nuestro secreto de éxito.Máxima calidad en cada uno de los productos", 20, 10, "Tío_Paco", "pastel");
        Plato p72 = new Plato(72, "Croquetas de cocido", "Con la receta de Paco,inamovible en el tiempo.Una delicia", 12, 6, "Tío_Paco", "croquetas");
        Plato p73 = new Plato(73, "Revuelto de Morcilla", "Premio nacional de gastronomía.Una de nuestras delicias", 14, 9, "Tío_Paco", "revuelto");
        Plato p74 = new Plato(74, "Tartar de Salmón Noruego", "El mejor atún que hay en el mercado.Calidad Suprema", 20, 8, "Tío_Paco", "tartar2");
        Plato p75 = new Plato(75, "Pulpito de roca gallego en parrilla", "Como buenos gallegos,nuestro pulpo es uno de los platos más mimados", 18, 8, "Tío_Paco", "pulpito");
        Plato p76 = new Plato(76, "Judiones de la granja", "Auténticos de la granja segoviana al estilo tradicional gallego", 13, 10, "Tío_Paco", "judiones");
        Plato p77 = new Plato(77, "Chuletón de vaca vieja gallega", "Uno de nuestros platos que más orgullo nos provoca.Calidad reconocida", 28, 7, "Tío_Paco", "vieja");
        Plato p78 = new Plato(78, "Lubina salvaje a la parrilla", "Recién llegada de nuestra tierra a tu plato ,con un máximo de 24h", 16, 7, "Tío_Paco", "lubina2");
        Plato p79 = new Plato(79, "Rodaballo salvaje a la parrilla", "Tenemos el orgullo de poder decir que tenemos el mejor rodaballo de Galicia", 18, 8, "Tío_Paco", "rodaballo");
        Plato p80 = new Plato(80, "Hamburguesa especial Wagyu", "Carne de Kobe.Una de las mejores hamburguesas del planeta", 25, 8, "Tío_Paco", "wagyu");

        platos_Tio_Paco = new ArrayList<>(Arrays.asList(p71, p72, p73, p74, p75, p76, p77, p78, p79, p80));

        Plato p81 = new Plato(81, "Codorniz escabechada", "Una receta para todo el año,no sólo para la temporada de caza", 12, 7, "Gourmet", "codorniz");
        Plato p82 = new Plato(82, "Huevos rotos con boletus y trufa", "Un plato sencillo pero que siempre triunfa.Aprovecha la temporada de setas", 11, 9, "Gourmet", "trufa");
        Plato p83 = new Plato(83, "Rollitos de lenguado", "Deliciciosa receta elaborada con uno de los pescados más saludables de nuestra gastronomía", 12, 6, "Gourmet", "rollitos2");
        Plato p84 = new Plato(84, "Merluza rellena de gambas", "Horneada atemperatura baja con el mimo de los grandes cocineros", 14, 8, "Gourmet", "merluza");
        Plato p85 = new Plato(85, "Silla de cordero", "Por su grasa y su fuerte sabor es ideal para combinarlo con sabores ácidos y dulces", 16, 10, "Gourmet", "silla");
        Plato p86 = new Plato(86, "Medallones de Bogavante", "El sabor del espárrago,el ahumado del salmón y el sabor yodado del crústaceo.Locura!", 16, 8, "Gourmet", "medallon");
        Plato p87 = new Plato(87, "Jamón asado a la Gallega", "Es una delicia de receta.Plato típico gallego", 14, 12, "Gourmet", "asado");
        Plato p88 = new Plato(88, "Salmonetes a la plancha sobre risotto", "Delicioso arroz cremoso que se deshace en la boca,textura untosa y suave sabor", 14, 9, "Gourmet", "salmonetes");
        Plato p89 = new Plato(89, "Albóndigas de Turingia", "No son de carne,sino de papas.Acompañadas de un buen asado,con su correspondiente salsa sabrosa.", 13, 6, "Gourmet", "papas");
        Plato p90 = new Plato(90, "Brochetas de cordero", "Es una receta típica.Marinadas con una salsa de confit de manzana", 14, 8, "Gourmet", "brochetas");

        platos_Gourmet = new ArrayList<>(Arrays.asList(p81, p82, p83, p84, p85, p86, p87, p88, p89, p90));

        Plato p91 = new Plato(91, "Chuletillas de cordero", "Lechal de Segovia (6 Piezas)", 18, 6, "Minotauro", "chuletas");
        Plato p92 = new Plato(92, "Villagodio Supremo", "Chuletón de lomo alto con 5 semanas de maduración (800g sin hueso)", 52, 5, "Minotauro", "villagodio");
        Plato p93 = new Plato(93, "Steak tartar de Solomillo", "Cortado a cuchillo y acabado a su gusto con regañas", 22, 8, "Minotauro", "tartar");
        Plato p94 = new Plato(94, "Rabo de Buey", "Macerado en Pedro Ximénez y guisado al 'Chup Chup' como en Córdoba", 18, 10, "Minotauro", "rabo2");
        Plato p95 = new Plato(95, "Vacío de Kobe", "De vaca Waygu.Australia (250g)", 24, 8, "Minotauro", "vacio");
        Plato p96 = new Plato(96, "Degustación de carnes", "5 escalopines de 50g.Entrecot,solomillo de avestruz,escalopines de canguro,lomo de cebra y vacio de Kobe", 24, 8, "Minotauro", "degustacion");
        Plato p97 = new Plato(97, "Entraña", "carne roja con 27 días de maduración (300g)", 19, 7, "Minotauro", "entrania");
        Plato p98 = new Plato(98, "Solomillo de Ibérico", "En medallones,con reducción de Pedro Ximénez y arroz al curry", 16, 8, "Minotauro", "solomillo3");
        Plato p99 = new Plato(99, "Pulpo de roca", "Con puré de cachelo al pimentón (250g)", 20, 9, "Minotauro", "pulpito");
        Plato p100 = new Plato(100, "Lomo de atún rojo", "Poco hecho con sésamo tostado y mayonesa wasibi", 21, 8, "Minotauro", "atun_rojo");

        platos_Minotauro = new ArrayList<>(Arrays.asList(p91, p92, p93, p94, p95, p96, p97, p98, p99, p100));

        all_dishes = new ArrayList<>(Arrays.asList(platos_Alfredos, platos_Babel, platos_Orecanto, platos_Pulcinella, platos_Sushita, platos_Trattoria, platos_El_Asador, platos_Tio_Paco, platos_Gourmet, platos_Minotauro));

        return all_dishes;

    }
}
