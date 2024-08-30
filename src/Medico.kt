class Medico(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    codigoEmpleado: String,
    numeroHorasExtras: Int,
    fechaIngreso: String,
    area: String,
    cargo: String,
    salarioMensual: Double,
    porcentajeAdicionalHoraExtra: Double,
    val especialidad: String,
    val servicio: String,
    val numeroConsultorio: String
) : EmpleadoPorPlanilla(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, numeroHorasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra)