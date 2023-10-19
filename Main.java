  import java.util.Scanner;

  public class Main {
      static double saldo = 0;
      static boolean tieneCuenta = false;

      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int opcion;

          System.out.println("Bienvenido al sistema bancario");

          System.out.print("¿Ya tiene una cuenta? (s/n): ");
          String respuesta = sc.nextLine();

          if (respuesta.equalsIgnoreCase("s")) {
              tieneCuenta = true;
          } else {
              registrarCuenta(sc);
          }

          if (tieneCuenta) {
              do {
                  System.out.println("1. Retirar");
                  System.out.println("2. Depositar");
                  System.out.println("3. Transferir");
                  System.out.println("4. Ver saldo");
                  System.out.println("5. Salir");
                  System.out.print("Ingrese su opción: ");
                  opcion = sc.nextInt();

                  switch (opcion) {
                      case 1:
                          retirar(sc);
                          break;
                      case 2:
                          depositar(sc);
                          break;
                      case 3:
                          transferir(sc);
                          break;
                      case 4:
                          verSaldo();
                          break;
                      case 5:
                          System.out.println("Saliendo del sistema bancario. ¡Hasta luego!");
                          break;
                      default:
                          System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                  }
              } while (opcion != 5);
          }
      }

      public static void registrarCuenta(Scanner sc) {
          System.out.println("Proceso de registro de cuenta:");
          System.out.print("Ingrese su nombre: ");
          String nombre = sc.nextLine();
          System.out.print("Ingrese su dirección: ");
          String direccion = sc.nextLine();
          System.out.print("Ingrese su número de teléfono: ");
          String telefono = sc.nextLine();
          // Agregar lógica adicional según sea necesario

          // Lógica para crear la cuenta y almacenar la información
          System.out.println("¡Registro exitoso! Ahora tiene una cuenta en nuestro sistema bancario.");
          tieneCuenta = true;
      }

    public static void retirar(Scanner sc) {
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = sc.nextDouble();
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente. No se puede realizar el retiro.");
        } else {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Saldo restante: " + saldo);
        }
    }


    public static void depositar(Scanner sc) {
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = sc.nextDouble();
        saldo += cantidad;
        System.out.println("Depósito exitoso. Saldo actual: " + saldo);
    }


    public static void transferir(Scanner sc) {
        System.out.print("Ingrese la cantidad a transferir: ");
        double cantidad = sc.nextDouble();
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente. No se puede realizar la transferencia.");
        } else {
            saldo -= cantidad;
            System.out.println("Transferencia exitosa. Saldo restante: " + saldo);
        }
    }
    
    public static void verSaldo() {
        System.out.println("Su saldo actual es: " + saldo);
    }

  }
