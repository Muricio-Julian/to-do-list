async function crearTarea(tareaData) {
    try {
        const response = await fetch("http://localhost:8080/api/v1/reservs", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(tareaData),
        });

        const data = await response.json();
        console.log(data); // Datos de la reserva creada
        // Aquí puedes realizar acciones adicionales después de crear la reserva
        return data;
    } catch (error) {
        console.error("Error al crear la Tarea:", error);
        throw error;
    }
}

async function obtenerTareas() {
    try {
        const response = await fetch("http://localhost:8080/api/v1/reservs");
        const Tareas = await response.json();
        console.log(Tareas); // Lista de reservas obtenidas
        // Aquí puedes mostrar las reservas en el frontend o realizar otras acciones
        actualizarListaTareas(Tareas); // Llama a la función para mostrar las reservas en el HTML
    } catch (error) {
        console.error("Error al obtener las Tareas:", error);
        throw error;
    }
}

async function actualizarTareas(tareaId, updatedData) {
    try {
        const response = await fetch(
            `http://localhost:8080/api/v1/reservs/${tareaId}`,
            {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(updatedData),
            }
        );

        const data = await response.json();
        console.log(data); // Datos de la reserva actualizada
        // Aquí puedes realizar acciones adicionales después de actualizar la reserva
        return data;
    } catch (error) {
        console.error("Error al actualizar la Tarea:", error);
        throw error;
    }
}

async function eliminarReserva(tareaId) {
    try {
        const response = await fetch(
            `http://localhost:8080/api/v1/reservs/${tareaId}`,
            {
                method: "DELETE",
            }
        );

        const data = await response.json();
        console.log(data); // Datos de la respuesta después de eliminar la reserva
        // Aquí puedes realizar acciones adicionales después de eliminar la reserva
        return data;
    } catch (error) {
        console.error("Error al eliminar la tarea:", error);
        throw error;
    }
}