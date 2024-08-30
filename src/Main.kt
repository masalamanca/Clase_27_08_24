import java.util.Random
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val empleados = mutableListOf<Empleado>()
    val pacientes = mutableListOf<Paciente>()
    val medicos = mutableListOf<Medico>()
    val citasMedicas = mutableListOf<CitaMedica>()
    val random = Random()

    while (true) {
        println("Menú de opciones:")
        println("1. Registrar Empleado")
        println("2. Registrar Paciente")
        println("3. Registrar Médico")
        println("4. Registrar Cita Médica")
        println("5. Listar Médicos por Especialidad")
        println("6. Listar Pacientes Atendidos por Médico")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> {
                print("¿Desea ingresar los datos manualmente (1) o generarlos aleatoriamente (2)? ")
                when (scanner.nextInt()) {
                    1 -> {
                        println("Ingrese los datos del empleado:")
                        print("DNI: ")
                        val dni = scanner.next()
                        print("Nombre: ")
                        val nombre = scanner.next()
                        print("Apellido: ")
                        val apellido = scanner.next()
                        print("Fecha de Nacimiento: ")
                        val fechaNacimiento = scanner.next()
                        print("Dirección: ")
                        val direccion = scanner.next()
                        print("Ciudad de Procedencia: ")
                        val ciudadProcedencia = scanner.next()
                        print("Código de Empleado: ")
                        val codigoEmpleado = scanner.next()
                        print("Número de Horas Extras: ")
                        val numeroHorasExtras = scanner.nextInt()
                        print("Fecha de Ingreso: ")
                        val fechaIngreso = scanner.next()
                        print("Área: ")
                        val area = scanner.next()
                        print("Cargo: ")
                        val cargo = scanner.next()

                        val empleado = Empleado(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, numeroHorasExtras, fechaIngreso, area, cargo)
                        empleados.add(empleado)
                        println("Empleado registrado exitosamente.")
                    }
                    2 -> {
                        val empleado = generarEmpleadoAleatorio()
                        empleados.add(empleado)
                        println("Empleado generado aleatoriamente: $empleado")
                    }
                    else -> println("Opción no válida.")
                }
            }
            2 -> {
                print("¿Desea ingresar los datos manualmente (1) o generarlos aleatoriamente (2)? ")
                when (scanner.nextInt()) {
                    1 -> {
                        println("Ingrese los datos del paciente:")
                        print("DNI: ")
                        val dni = scanner.next()
                        print("Nombre: ")
                        val nombre = scanner.next()
                        print("Apellido: ")
                        val apellido = scanner.next()
                        print("Fecha de Nacimiento: ")
                        val fechaNacimiento = scanner.next()
                        print("Dirección: ")
                        val direccion = scanner.next()
                        print("Ciudad de Procedencia: ")
                        val ciudadProcedencia = scanner.next()
                        print("Número de Historia Clínica: ")
                        val numeroHistoriaClinica = scanner.next()
                        print("Sexo: ")
                        val sexo = scanner.next()
                        print("Grupo Sanguíneo: ")
                        val grupoSanguineo = scanner.next()
                        print("Lista de Alergias (separadas por comas): ")
                        val listaAlergias = scanner.next().split(",")

                        val paciente = Paciente(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, numeroHistoriaClinica, sexo, grupoSanguineo, listaAlergias)
                        pacientes.add(paciente)
                        println("Paciente registrado exitosamente.")
                    }
                    2 -> {
                        val paciente = generarPacienteAleatorio()
                        pacientes.add(paciente)
                        println("Paciente generado aleatoriamente: $paciente")
                    }
                    else -> println("Opción no válida.")
                }
            }
            3 -> {
                print("¿Desea ingresar los datos manualmente (1) o generarlos aleatoriamente (2)? ")
                when (scanner.nextInt()) {
                    1 -> {
                        println("Ingrese los datos del médico:")
                        print("DNI: ")
                        val dni = scanner.next()
                        print("Nombre: ")
                        val nombre = scanner.next()
                        print("Apellido: ")
                        val apellido = scanner.next()
                        print("Fecha de Nacimiento: ")
                        val fechaNacimiento = scanner.next()
                        print("Dirección: ")
                        val direccion = scanner.next()
                        print("Ciudad de Procedencia: ")
                        val ciudadProcedencia = scanner.next()
                        print("Código de Empleado: ")
                        val codigoEmpleado = scanner.next()
                        print("Número de Horas Extras: ")
                        val numeroHorasExtras = scanner.nextInt()
                        print("Fecha de Ingreso: ")
                        val fechaIngreso = scanner.next()
                        print("Área: ")
                        val area = scanner.next()
                        print("Cargo: ")
                        val cargo = scanner.next()
                        print("Salario Mensual: ")
                        val salarioMensual = scanner.nextDouble()
                        print("Porcentaje Adicional por Hora Extra: ")
                        val porcentajeAdicionalHoraExtra = scanner.nextDouble()
                        print("Especialidad: ")
                        val especialidad = scanner.next()
                        print("Servicio: ")
                        val servicio = scanner.next()
                        print("Número de Consultorio: ")
                        val numeroConsultorio = scanner.next()

                        val medico = Medico(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, numeroHorasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra, especialidad, servicio, numeroConsultorio)
                        medicos.add(medico)
                        println("Médico registrado exitosamente.")
                    }
                    2 -> {
                        val medico = generarMedicoAleatorio()
                        medicos.add(medico)
                        println("Médico generado aleatoriamente: $medico")
                    }
                    else -> println("Opción no válida.")
                }
            }
            4 -> {
                print("¿Desea ingresar los datos manualmente (1) o generarlos aleatoriamente (2)? ")
                when (scanner.nextInt()) {
                    1 -> {
                        println("Ingrese los datos de la cita médica:")
                        print("DNI del Paciente: ")
                        val dniPaciente = scanner.next()
                        val paciente = pacientes.find { it.dni == dniPaciente }
                        if (paciente == null) {
                            println("Paciente no encontrado.")
                            continue
                        }
                        print("Código del Médico: ")
                        val codigoMedico = scanner.next()
                        val medico = medicos.find { it.codigoEmpleado == codigoMedico }
                        if (medico == null) {
                            println("Médico no encontrado.")
                            continue
                        }
                        print("Fecha de la Cita (dd/MM/yyyy): ")
                        val fecha = scanner.next()
                        print("Hora de la Cita (HH:mm): ")
                        val hora = scanner.next()

                        val citaMedica = CitaMedica(paciente, medico, fecha, hora)
                        citasMedicas.add(citaMedica)
                        println("Cita médica registrada exitosamente.")
                    }
                    2 -> {
                        if (pacientes.isEmpty() || medicos.isEmpty()) {
                            println("No se pueden generar citas médicas sin pacientes o médicos.")
                        } else {
                            val citaMedica = generarCitaMedicaAleatoria(pacientes, medicos)
                            if (citaMedica != null) {
                                citasMedicas.add(citaMedica)
                                println("Cita médica generada aleatoriamente: $citaMedica")
                            } else {
                                println("No se puede generar una cita médica debido a la falta de pacientes o médicos.")
                            }
                        }
                    }
                    else -> println("Opción no válida.")
                }
            }
            5 -> {
                val especialidades = medicos.map { it.especialidad }.distinct()
                if (especialidades.isEmpty()) {
                    println("No hay especialidades registradas.")
                } else {
                    println("Especialidades disponibles:")
                    especialidades.forEachIndexed { index, especialidad -> println("${index + 1}. $especialidad") }
                    print("Seleccione una especialidad por número: ")
                    val opcion = scanner.nextInt()
                    if (opcion in 1..especialidades.size) {
                        val especialidadSeleccionada = especialidades[opcion - 1]
                        val medicosPorEspecialidad = medicos.filter { it.especialidad == especialidadSeleccionada }
                        if (medicosPorEspecialidad.isEmpty()) {
                            println("No se encontraron médicos con la especialidad $especialidadSeleccionada.")
                        } else {
                            println("Médicos con la especialidad $especialidadSeleccionada:")
                            medicosPorEspecialidad.forEach { println("${it.nombre} ${it.apellido}") }
                        }
                    } else {
                        println("Opción no válida.")
                    }
                }
            }
            6 -> {
                if (medicos.isEmpty()) {
                    println("No hay médicos registrados.")
                } else {
                    println("Médicos disponibles:")
                    medicos.forEachIndexed { index, medico -> println("${index + 1}. ${medico.nombre} ${medico.apellido} (Código: ${medico.codigoEmpleado})") }
                    print("Seleccione un médico por número: ")
                    val opcion = scanner.nextInt()
                    if (opcion in 1..medicos.size) {
                        val medicoSeleccionado = medicos[opcion - 1]
                        val pacientesAtendidos = citasMedicas.filter { it.medico.codigoEmpleado == medicoSeleccionado.codigoEmpleado }.map { it.paciente }
                        if (pacientesAtendidos.isEmpty()) {
                            println("El médico con código ${medicoSeleccionado.codigoEmpleado} no tiene pacientes asignados.")
                        } else {
                            println("Pacientes atendidos por el médico ${medicoSeleccionado.nombre} ${medicoSeleccionado.apellido} (Código: ${medicoSeleccionado.codigoEmpleado}):")
                            pacientesAtendidos.forEach { println("${it.nombre} ${it.apellido}") }
                        }
                    } else {
                        println("Opción no válida.")
                    }
                }
            }
            7 -> {
                println("Saliendo del programa...")
                return
            }
            else -> println("Opción no válida, intente de nuevo.")
        }
    }
}

fun asignarPacientesAMedicos(pacientes: List<Paciente>, medicos: List<Medico>, citasMedicas: MutableList<CitaMedica>) {
    if (pacientes.isEmpty() || medicos.isEmpty()) {
        println("No se puede asignar pacientes a médicos sin pacientes o médicos.")
        return
    }
    val pacienteIterator = pacientes.iterator()
    var medicoIterator = medicos.iterator()

    while (pacienteIterator.hasNext()) {
        val paciente = pacienteIterator.next()
        val medico = if (medicoIterator.hasNext()) medicoIterator.next() else {
            medicoIterator = medicos.iterator() // Reiniciar el iterador si se agotaron los médicos
            medicoIterator.next()
        }
        val citaMedica = CitaMedica(paciente, medico, "01/01/2024", "10:00") // Fecha y hora de ejemplo
        citasMedicas.add(citaMedica)
        println("Paciente ${paciente.nombre} ${paciente.apellido} asignado al médico ${medico.nombre} ${medico.apellido}.")
    }
}

fun generarEmpleadoAleatorio(): Empleado {
    val nombres = listOf("Carlos", "Ana", "Luis", "Maria", "Pedro", "Sofia")
    val apellidos = listOf("Gonzalez", "Martinez", "Lopez", "Perez", "Sanchez", "Fernandez")
    val areas = listOf("Recursos Humanos", "Finanzas", "Marketing", "IT", "Ventas")
    val cargos = listOf("Gerente", "Analista", "Asistente", "Coordinador", "Director")
    val random = Random()
    return Empleado(
        dni = "DNI${random.nextInt(10000)}",
        nombre = nombres[random.nextInt(nombres.size)],
        apellido = apellidos[random.nextInt(apellidos.size)],
        fechaNacimiento = "01/01/1980",
        direccion = "Dirección ${random.nextInt(100)}",
        ciudadProcedencia = "Ciudad ${random.nextInt(100)}",
        codigoEmpleado = "C${random.nextInt(10000)}",
        numeroHorasExtras = random.nextInt(100),
        fechaIngreso = "01/01/2020",
        area = areas[random.nextInt(areas.size)],
        cargo = cargos[random.nextInt(cargos.size)]
    )
}

fun generarPacienteAleatorio(): Paciente {
    val nombres = listOf("Carlos", "Ana", "Luis", "Maria", "Pedro", "Sofia")
    val apellidos = listOf("Gonzalez", "Martinez", "Lopez", "Perez", "Sanchez", "Fernandez")
    val gruposSanguineos = listOf("A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-")
    val alergias = listOf("Penicilina", "Aspirina", "Lactosa", "Gluten", "Polen")
    val random = Random()
    return Paciente(
        dni = "DNI${random.nextInt(10000)}",
        nombre = nombres[random.nextInt(nombres.size)],
        apellido = apellidos[random.nextInt(apellidos.size)],
        fechaNacimiento = "01/01/1990",
        direccion = "Dirección ${random.nextInt(100)}",
        ciudadProcedencia = "Ciudad ${random.nextInt(100)}",
        numeroHistoriaClinica = "HC${random.nextInt(10000)}",
        sexo = if (random.nextBoolean()) "M" else "F",
        grupoSanguineo = gruposSanguineos[random.nextInt(gruposSanguineos.size)],
        listaAlergias = listOf(alergias[random.nextInt(alergias.size)])
    )
}

fun generarMedicoAleatorio(): Medico {
    val nombres = listOf("Carlos", "Ana", "Luis", "Maria", "Pedro", "Sofia")
    val apellidos = listOf("Gonzalez", "Martinez", "Lopez", "Perez", "Sanchez", "Fernandez")
    val especialidades = listOf("Cardiología", "Dermatología", "Ginecología", "Neurología", "Pediatría")
    val servicios = listOf("Consulta General", "Emergencias", "Chequeo Anual", "Tratamiento Especializado")
    val random = Random()
    return Medico(
        dni = "DNI${random.nextInt(10000)}",
        nombre = nombres[random.nextInt(nombres.size)],
        apellido = apellidos[random.nextInt(apellidos.size)],
        fechaNacimiento = "01/01/1980",
        direccion = "Dirección ${random.nextInt(100)}",
        ciudadProcedencia = "Ciudad ${random.nextInt(100)}",
        codigoEmpleado = "C${random.nextInt(10000)}",
        numeroHorasExtras = random.nextInt(100),
        fechaIngreso = "01/01/2015",
        area = "Área ${random.nextInt(10)}",
        cargo = "Cargo ${random.nextInt(10)}",
        salarioMensual = random.nextDouble(5000.0),
        porcentajeAdicionalHoraExtra = random.nextDouble(20.0),
        especialidad = especialidades[random.nextInt(especialidades.size)],
        servicio = servicios[random.nextInt(servicios.size)],
        numeroConsultorio = "Consultorio ${random.nextInt(100)}"
    )
}

fun generarCitaMedicaAleatoria(pacientes: List<Paciente>, medicos: List<Medico>): CitaMedica? {
    if (pacientes.isEmpty() || medicos.isEmpty()) return null
    val random = Random()
    val paciente = pacientes[random.nextInt(pacientes.size)]
    val medico = medicos[random.nextInt(medicos.size)]
    val fecha = "01/01/2024"
    val hora = "${random.nextInt(24)}:${random.nextInt(60).toString().padStart(2, '0')}"
    return CitaMedica(paciente, medico, fecha, hora)
}

