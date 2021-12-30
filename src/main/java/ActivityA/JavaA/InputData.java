/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActivityA.JavaA;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MSI 65 SERIES
 */
    @Controller 
public class InputData {
    @RequestMapping("/prosesinput")
    public String inputanuser(HttpServletRequest data, Model buah){
        InputData2 InptData2 = new InputData2();
        //getting data
        String namabuah = data.getParameter("var_namabuah");
        String hargabuah = data.getParameter("var_hargaperkilo");
        String jumlahbuah = data.getParameter("var_jumlahbeli");
        //import data from process to variabel
        
        Double convharga        = InptData2.newharga(hargabuah);
        Double convjumlah       = InptData2.newjumlah(jumlahbuah);
        Double jumlahbayar      = InptData2.newjumlahbayar(convharga, convjumlah);
        String diskonpersen     = InptData2.diskon(jumlahbayar);
        Double hargadiskon      = InptData2.newhargadiskon(jumlahbayar, Integer.valueOf(diskonpersen));
        Double totalbayar       = InptData2.newtotalbayar(jumlahbayar, hargadiskon);
        InptData2.math(jumlahbayar, Integer.SIZE, totalbayar, hargadiskon);
        //
        buah.addAttribute("name", namabuah);
        buah.addAttribute("price", hargabuah);
        buah.addAttribute("kilo", jumlahbuah);
        buah.addAttribute("total0", jumlahbayar);
        buah.addAttribute("discountrp", hargadiskon);
        buah.addAttribute("disc", diskonpersen);
        buah.addAttribute("tbayar", totalbayar);
        return "RizvaldiF";
    }  
    
}

