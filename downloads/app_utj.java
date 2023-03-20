/**
 *
 * @author Alumnos UTJCCD
 * Diego Alexis Baeza Rodriguez
 */
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class app_utj {
    public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      int opcion_jug = -1, opcion_arbitros= -1, opcion_juegos= -1, opcion_final = -1, opcion = -1, opcion_2 = -1;
      final String USUARIO = "admin"; 
      final String CONTRASEÑA = "admin1"; 
      int golesT1 = 0, golesT2 = 0, golesTotales = 0;
      int faltas = 0;
      int t1_1 = 0, t1_2 = 0, t1_3 = 0, t1_4 = 0, t1_5 = 0, t1_6 = 0, t1_7 = 0;
      int t2_1 = 0, t2_2 = 0, t2_3 = 0, t2_4 = 0, t2_5 = 0, t2_6 = 0, t2_7 = 0;
      LocalDate fecha_juego = LocalDate.now();
      LocalDate fecha_actual = LocalDate.now();
      int dias_para_el_juego = 0;
      int hora_juego = 0;
      int minuto_juego = 0;
      LocalTime hora_tiempo = LocalTime.now();
      int partido_activado = -1;
      int opcion_arbitro = 0;

      String usu, contra;
      String[] equipos = new String[] {"", "", "", "", "", "", ""};
/*       String[][] jugadores = new String[] {{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}}; */
      String[][] jugadores;
      jugadores = new String [7][7];
      String[] arbitros = new String [5];
      int[][] goles = new int[7][7];
      int[][] tarjetas_rojas = new int[7][7];
      int[][] tarjetas_amarillas = new int[7][7];
      int opcion_tarjeta = 0;
      int cantidad_tarjetas = 0;
      int cantidad_goles = 0;
      DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy").withLocale(new Locale("es", "ES"));
      Period fecha_restante_torneo = Period.between(fecha_juego, fecha_actual);
      int dias_restantes_torneo = 0;
      int esta_activo = 0, esta_activo_2 = 0;
      int esta_activo_3 = 0;

      do {
        System.out.println("Bienvenido");
        System.out.println("Introduce nombre de usuario");
      usu = teclado.next();
        System.out.println("Introduce la contraseña");
        contra = teclado.next();
        if (!usu.equals(USUARIO) || !contra.equals(CONTRASEÑA)) {
        System.out.println("Usuario y contraseña incorrectos");
        }
      } while (!(usu.equals(USUARIO) && contra.equals(CONTRASEÑA)));

      do {
        System.out.println("\n\033[0;1m Bienvenido \u001B[0m " + USUARIO);
        System.out.println("\033[0;1m Selecciona una opcion \u001B[0m");
        System.out.println("0) Salir");
         System.out.println("1) Crear Torneo");
         System.out.println("2) Ver datos");
         System.out.println("3) Editar (Opcion del arbitro)");

        opcion_final = teclado.nextInt();

        switch (opcion_final) {
          case 0:
        System.out.println("Adios");
            break;
          case 1:
        System.out.println("\n\t\033[0;1mTorneo nuevo\u001B[0m");
        System.out.print("\tCuantos equipos son: ");
        opcion_jug = teclado.nextInt();
        for (int i = 0; i < opcion_jug; i++) {
          System.out.print("\n\tNombre del equipo " + (i + 1 ) + ": ");
          equipos[i] = teclado.next();
          System.out.println("\t\033[0;1mSeleccion de jugadores del equipo: \u001B[0m" + equipos[i]);
          System.out.println("\tDebe ser 7 jugadores por equipo");
          System.out.print("\t\tJugador 1: ");
          jugadores[i][0] = teclado.next();
          System.out.print("\t\tJugador 2: ");
          jugadores[i][1] = teclado.next();
          System.out.print("\t\tJugador 3: ");
          jugadores[i][2] = teclado.next();
          System.out.print("\t\tJugador 4: ");
          jugadores[i][3] = teclado.next();
          System.out.print("\t\tJugador 5: ");
          jugadores[i][4] = teclado.next();
          System.out.print("\t\tJugador 6: ");
          jugadores[i][5] = teclado.next();
          System.out.print("\t\tJugador 7: ");
          jugadores[i][6] = teclado.next();

        }
        System.out.print("\n\tCuantos arbitros estan disponibles? : ");
        opcion_arbitros = teclado.nextInt();

        for (int i = 0; i < opcion_arbitros; i++) {
        System.out.print("\tNombre del arbitro " + (i + 1) + ": ");
           arbitros[i] = teclado.next();
        }

        System.out.print("\tCuantos juegos se jugaran? : ");
        opcion_juegos = teclado.nextInt();

        System.out.print("\tDentro de cuantos dias se jugara el torneo? : ");
        dias_para_el_juego = teclado.nextInt();
        fecha_juego = LocalDate.now().plusDays(dias_para_el_juego);

        System.out.print("\tHora que empezara el torneo? : ");
        hora_juego = teclado.nextInt();
        System.out.print("\tMinuto que empezara el torneo? : ");
        minuto_juego = teclado.nextInt();
        hora_tiempo = LocalTime.of(hora_juego, minuto_juego);
        fecha_restante_torneo = Period.between(fecha_actual, fecha_juego );
        dias_restantes_torneo = fecha_restante_torneo.getDays();

            break;
          case 2:
          if (opcion_jug != -1) {
            System.out.println("\n"+ "\033[0;1m" + "Datos actuales del torneo \u001B[0m");
            for (int i = 0; i < opcion_jug; i++) {
              System.out.println("\n\t\033[0;1mJugadores del equipo " +(i+1) +": \u001B[0m"+ equipos[i]);
    
              for (int j = 0; j < jugadores[i].length; j++) {
                  System.out.println("\t\tjugador " + (j +1) + ": " +jugadores[i][j] );
                  
                }
    
              }

              if (partido_activado == 1) {
              for (int i = 0; i < opcion_jug; i++) {
                System.out.println("\n\t\033[0;1mGoles de jugadores del equipo " +(i+1) +": \u001B[0m"+ equipos[i]);
      
                for (int j = 0; j < jugadores[i].length; j++) {
                  if (goles[i][j] != 0) {
                    esta_activo_3 = 1;
                    System.out.println("\t\tjugador " +jugadores[i][j] + " tiene: " + goles[i][j]+ " goles");
                  }
                  
                }
                if (esta_activo_3 != 1) {
                  System.out.println("\t\t0 goles");
                  
                }
              }

              for (int i = 0; i < opcion_jug; i++) {
                System.out.println("\n\t\033[0;1mTarjetas de jugadores del equipo " +(i+1) +": \u001B[0m"+ equipos[i]);
      
                for (int j = 0; j < jugadores[i].length; j++) {
                  if (tarjetas_amarillas[i][j] != 0) {
                    esta_activo = 1;
                    System.out.println("\t\tjugador " +jugadores[i][j] + " tiene: " + tarjetas_amarillas[i][j] + " tarjetas amarillas");
                  }
                  if (tarjetas_rojas[i][j] != 0) {
                    esta_activo_2 = 1;
                    System.out.println("\t\tjugador " +jugadores[i][j] + " tiene: " + tarjetas_rojas[i][j] + " tarjetas rojas");
                  }
                  
                }
                if (esta_activo != 1) {
                  System.out.println("\t\t0 tarjetas amarillas");
                  
                }
                if (esta_activo_2 != 1) {
                  System.out.println("\t\t0 tarjetas rojas");
                  
                }
              }
            }
                

            System.out.println("\n \t \033[0;1mArbitros \u001B[0m");
            for (int l = 0; l < opcion_arbitros; l++) {
                  System.out.println("\t\tArbitro " + (l +1) + ": " + arbitros[l]);
            } 
            System.out.println("\n\t\033[0;1m Juegos a celebrarse \u001B[0m");
            System.out.println("\t\t" + opcion_juegos);
    
            System.out.println("\n\t\033[0;1m Fecha que iniciara el juego \u001B[0m");
            System.out.println("\t\t" +  fecha_juego.format(esDateFormat));
            System.out.println("\t\t" + "Faltan " +dias_restantes_torneo + " dias para el torneo");
    
            System.out.println("\n\t\033[0;1m Hora del juego \u001B[0m");

            System.out.println("\t\t \u001B[3mLos partidos se desarrollaran en 2 tiempos de 20 minutos sin parar en un momento (tiempo corrido), con descansos de 5 minutos cada uno\u001B[0m \n");
            System.out.println("\t\t Inicio del primero juego: " +  hora_tiempo);

            for (int i = 1; i < opcion_juegos; i++) {

              hora_tiempo = hora_tiempo.plusMinutes(5);
              System.out.println("\t\t Descanso: " + hora_tiempo );
              hora_tiempo = hora_tiempo.plusMinutes(40);
              System.out.println("\t\t Juego " + i + ": " +  hora_tiempo);
              
            }
          
          } else {
            System.out.println("\t\t No hay torneos creados");
          }
          break;
          case 3:
          if (opcion_jug != -1 /* ||  fecha_actual == fecha_juego */){
            System.out.println("\n\t\033[0;1mModo edicion del arbitro\u001B[0m");
            partido_activado = 1;
            opcion_arbitro = 1;
            while (opcion_arbitro != 0) {
              System.out.println("0) Salir");
              System.out.println("1) Registrar goles");
              System.out.println("2) Registrar tarjetas");

/*               for (int i = 0; i < opcion_arbitro_jug; i++) {
                System.out.println("\n\t\033[0;1mJugadores del equipo " +(i+1) +": \u001B[0m"+ equipos[i]);
      
                for (int j = 0; j < jugadores[i].length; j++) {
                    System.out.println("\t\tjugador " + (j +1) + ": " +jugadores[i][j] );
                    
                  }
      
                } */
              opcion_arbitro = teclado.nextInt();
              switch (opcion_arbitro) {
                case 1:
                System.out.println("\n\t\033[0;1m Selecciona un equipo\u001B[0m");
                for (int i = 0; i < opcion_jug; i++) {
                  System.out.println("\n\t\033[0;1m" + (i+1) +") Equipo: \u001B[0m"+ equipos[i]);
                  }
                  System.out.println("\t");
                  opcion = teclado.nextInt();
                  opcion -= 1;
                  System.out.println("\n\t\033[0;1m Selecciona un jugador\u001B[0m");

                    for (int j = 0; j < 7; j++) {
                      System.out.println("\t\t"+(j +1) +") jugador: " +jugadores[opcion][j] );
                    }
                    
                    opcion_2 = teclado.nextInt();
                    opcion_2 -= 1;
                  System.out.println("\t\tJugador "+ jugadores[opcion][opcion_2] +" selccionado ");
                  System.out.println("\t\tCantidad de goles: ");
                  cantidad_goles = teclado.nextInt();

                  goles[opcion][opcion_2] = cantidad_goles;
              
                  break;
                case 2:
                  System.out.println("\n\t\033[0;1m Selecciona un equipo\u001B[0m");
                  for (int i = 0; i < opcion_jug; i++) {
                    System.out.println("\n\t\033[0;1m" + (i+1) +") Equipo: \u001B[0m"+ equipos[i]);
                    }
                    System.out.println("\t");
                    opcion = teclado.nextInt();
                    opcion -= 1;
                    System.out.println("\n\t\033[0;1m Selecciona un jugador\u001B[0m");
                      for (int j = 0; j < 7; j++) {
                        System.out.println("\t\t"+(j +1) +") jugador: " +jugadores[opcion][j] );
                      }
                      opcion_2 = teclado.nextInt();
                      opcion_2 -= 1;
                    System.out.println("\t\tJugador "+ jugadores[opcion][opcion_2] +" selccionado ");
                  System.out.println("\t\tSelecciona el tipo de tarjeta: ");
                  System.out.println("\t\t1) tarjeta amarilla: ");
                  System.out.println("\t\t2) tarjeta roja: ");
                  opcion_tarjeta = teclado.nextInt();
                  switch (opcion_tarjeta) {
                    case 1:
                      
                    System.out.println("\t\tEscriba la cantidad de tarjetas amarillas: ");
                    cantidad_tarjetas = teclado.nextInt();
                    tarjetas_amarillas[opcion][opcion_2] = cantidad_tarjetas;
                    System.out.println("\t\t\033[0;1mSe ha añadido correctamente\u001B[0m ");
                      break;

                    case 2:
                    System.out.println("\t\tEscriba la cantidad de tarjetas rojas: ");
                    cantidad_tarjetas = teclado.nextInt();
                    tarjetas_rojas[opcion][opcion_2] = cantidad_tarjetas;
                    System.out.println("\t\t\033[0;1mSe ha añadido correctamente\u001B[0m ");
                      break;
                  
                    default:
                      break;
                  }
              }                  
              }

            }else {
            System.out.println("\t\t No ha iniciado ningun torneo aun");
          }
          
      
            break;    
          default:
            break;
        }
      

        /* 
        switch (opcion_final) {
          case 0:
          System.out.println("Adios");
            break;
          case 1:
          System.out.println("Registro de goles");
          while (opcion != 0){
            System.out.println("¿Selecciona un equipo: \n0) Salir\n1) Equipo 1\n2) Equipo 2");
        opcion = teclado.nextInt();
          switch (opcion) {
            case 1:
            System.out.println(" Equipo 1 ");
            System.out.println(" Selecciona un jugador: ");
            System.out.println(" \t1) Juan carlos #17 ");
            System.out.println(" \t2) Pedro #8 ");
            System.out.println(" \t3) Joel #6 ");
            System.out.println(" \t4) Pablo #10 ");
            System.out.println(" \t5) Miguel #7 ");
            System.out.println(" \t6) Marcelo #14 ");
            System.out.println(" \t7) Josue #1 ");
            opcion = teclado.nextInt();
            switch (opcion) {
              case 1:
            System.out.println(" Juan carlos #17 ha registrado un gol ");
              t1_1 = t1_1 +1;
                System.out.println("Goles: " + t1_1);
                break;
              case 2:
            System.out.println(" Pedro #8 ha registrado un gol ");
              t1_2 = t1_2 +1;
                System.out.println("Goles: " + t1_2);
                break;
              case 3:
            System.out.println(" Joel #6 ha registrado un gol ");
              t1_3 = t1_3 +1;
                System.out.println("Goles: " + t1_3);
                break;
              case 4:
            System.out.println(" Pablo #10 ha registrado un gol ");
              t1_4 = t1_4 +1;
                System.out.println("Goles: " + t1_4);
                break;
              case 5:
            System.out.println(" Miguel #7 ha registrado un gol ");
              t1_5 = t1_5 +1;
                System.out.println("Goles: " + t1_5);
                break;
              case 6:
            System.out.println(" Marcelo #14 ha registrado un gol ");
              t1_6 = t1_6 +1;
                System.out.println("Goles: " + t1_6);
                break;
              case 7:
            System.out.println(" Josue #1 ha registrado un gol ");
              t1_7 = t1_7 +1;
                System.out.println("Goles: " + t1_7);
                break;
            
              default:
                break;
            }
              break;
            case 2:
            System.out.println(" Equipo 2");
            System.out.println(" \t1) Sebastian #8 ");
            System.out.println(" \t2) Pepe #9 ");
            System.out.println(" \t3) Joaquin #16 ");
            System.out.println(" \t4) Juan #7");
            System.out.println(" \t5) Jorge #2 ");
            System.out.println(" \t6) Diego #24 ");
            System.out.println(" \t7) Luis #66 ");
              break;
          
            default:
              break;
          }
          }
          golesTotales = golesT1 + golesT2;
          System.out.println("Se anotaron " + golesTotales + " goles en el juego");

            break;
          case 2:
          
          System.out.println("Registro de Tarjetas");
          while (opcion != 0){
            System.out.println("Tarjetas rojas: " + tarjetasRojas + "\nTarjetas amarillas: " + tarjetasAmarillas);
            System.out.println("¿Selecciona una opcion para registrar: \n0) salir\n1) Tarjeta roja\n2)Tarjeta amarilla");

            opcion = teclado.nextInt();
  
            switch (opcion) {
              case 1:
            System.out.println("¿Cuantas tarjetas rojas se mostraron en el partido?");
                tarjetasRojas = teclado.nextInt();
                break;
              case 2:
            System.out.println("¿Cuantas tarjetas amarillas se mostraron en el partido?");
                tarjetasAmarillas = teclado.nextInt();
                break;
            
              default:
                break;
            }
          }

            break;
          case 3:
          System.out.println("Registro de Faltas");
          while (opcion != 0){
            System.out.println("Faltas equipo 1: " + tarjetasRojas + "\nFaltas equipo 2: " + tarjetasAmarillas);
            System.out.println("¿Selecciona una opcion para registrar: \n0) salir\n1) Tarjeta roja\n2)Tarjeta amarilla");

            opcion = teclado.nextInt();
  
            switch (opcion) {
              case 1:
            System.out.println("¿Cuantas tarjetas rojas se mostraron en el partido?");
                tarjetasRojas = teclado.nextInt();
                break;
              case 2:
            System.out.println("¿Cuantas tarjetas amarillas se mostraron en el partido?");
                tarjetasAmarillas = teclado.nextInt();
                break;
            
              default:
                break;
            }
          }
            break;
          case 4:
          System.out.println("Adios");
            break;
          case 5:
          System.out.println("Adios");
            break;
          case 6:
          System.out.println("Adios");
            break;
          case 7:
          System.out.println("Adios");
            break;
        
          default:
            break;
        }*/
      } while (opcion_final != 0);
    
    }
  }