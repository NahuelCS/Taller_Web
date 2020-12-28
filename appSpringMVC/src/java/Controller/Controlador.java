/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Config.Conexion;
import Entidad.Persona;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //Anotaciones de Spring
public class Controlador {

    //Crearemos método Listar
    Conexion cnn = new Conexion();
    JdbcTemplate JdbcTemplate = new JdbcTemplate(cnn.Conectar()); //Llamando al metodo conectar a tráves de la clase JdbcTemplate
    ModelAndView mav = new ModelAndView();
    int id;
    List datos;

    @RequestMapping("index.htm")
    public ModelAndView Listar() {
        String sql = "SELECT * FROM persona";
        datos = JdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("index");
        return mav;
    }

    //Añadiremos el método Agregar():
    @RequestMapping(value = "agregar.htm", method = RequestMethod.GET)
    public ModelAndView Agregar() {
        mav.addObject(new Persona());
        mav.setViewName("agregar");
        return mav;
    }

    //Agregaremos el método Agregar-post():
    @RequestMapping(value = "agregar.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(Persona p) {
        String sql = "insert into persona(id,nombre,correo,nacionalidad) values(null,?,?,?)";
        this.JdbcTemplate.update(sql, p.getNombre(), p.getCorreo(), p.getNacionalidad());
        return new ModelAndView("redirect://index.htm");
    }

    //Agregamos el método editar-GET:
    @RequestMapping(value = "editar.htm", method = RequestMethod.GET)
    public ModelAndView Editar(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select*from persona where id=" + id;
        datos = this.JdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editar");
        return mav;
    }

    @RequestMapping(value = "editar.htm", method = RequestMethod.POST)
    public ModelAndView Editar(Persona p) {
        String sql = "update persona set nombre=?,correo=?,nacionalidad=? where id=" + id;
        this.JdbcTemplate.update(sql, p.getNombre(), p.getCorreo(), p.getNacionalidad());
        return new ModelAndView("redirect:/index.htm");
    }

    @RequestMapping("eliminar.htm")
    public ModelAndView Eliminar(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "delete from persona where id=" + id;
        this.JdbcTemplate.update(sql);
        return new ModelAndView("redirect:/index.htm");
    }
}
