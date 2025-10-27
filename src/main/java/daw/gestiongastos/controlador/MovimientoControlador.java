package daw.gestiongastos.controlador;

// ❗ Borra los imports no usados.
import daw.gestiongastos.entidad.Movimiento;
import daw.gestiongastos.servicio.IMovimientoServicio;
import daw.gestiongastos.servicio.MovimientoServicio;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MovimientoControlador {

    private static final String REDIRECT = "redirect:/";
    private static final Logger logger = LoggerFactory.getLogger(MovimientoControlador.class);

    @Autowired
    //
    private IMovimientoServicio movimientoServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Movimiento> movimientos = movimientoServicio.listarMovimientos();
        modelo.put("movimientos",movimientos);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar";
    }


    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("movimientoForma") Movimiento movimiento){
        movimientoServicio.agregarMovimiento(movimiento);
        return REDIRECT;
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") int idMovimiento, ModelMap modelo){

        Movimiento movimiento = movimientoServicio.buscarMovimientoPorId(idMovimiento);
        modelo.put("movimiento",movimiento);
        return "editar";
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("movimiento") Movimiento movimiento){
        // ❗No es "agregarMovimiento", es "editarMovimiento"
        movimientoServicio.agregarMovimiento(movimiento);
        return REDIRECT;
    }

    @GetMapping("/eliminar/{id}")
    // @DeleteMapping es más apropiado
    public String eliminar(
            @PathVariable(value = "id") int idMovimiento,
            RedirectAttributes redirectAttributes
    ) {
        //❗ El controlador no es responsable de esta lógica.
        // El responsable es MovimientoApp :)
        Movimiento movimiento = new Movimiento();
        movimiento.setIdMovimiento(idMovimiento);
        movimientoServicio.eliminarMovimiento(movimiento);

        //✅ 💪 Esta sí es una responsabilidad del controller.
        redirectAttributes.addFlashAttribute("msg_exito", "¡Se eliminó correctamente!");

        return REDIRECT;
    }


}
