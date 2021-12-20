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
        String namabuah = data.getParameter("var_namabuah");
        String hargabuah = data.getParameter("var_hargaperkilo");
        Integer chbuah = Integer.valueOf(hargabuah);
        String jumlahbuah = data.getParameter("var_jumlahbeli");
        Double cjbuah = Double.valueOf(jumlahbuah);
        Double jumlahbayar = chbuah * cjbuah;
        Double totalbayar = null;
        Integer diskon = 0;
        Double hargadiskon = 0.0;
        
        if(jumlahbayar < 16000){
            totalbayar = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
            
        }else if(jumlahbayar <=25000){
            diskon = 10;
            totalbayar = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
          
            
        }else{
            diskon = 15;
            totalbayar = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
        }
        buah.addAttribute("name", namabuah);
        buah.addAttribute("price", chbuah);
        buah.addAttribute("kilo", cjbuah);
        buah.addAttribute("tbayar", totalbayar);
        buah.addAttribute("discountrp", hargadiskon);
        buah.addAttribute("disc", diskon);
        buah.addAttribute("total0", jumlahbayar);
        return "RizvaldiF";
    }
    
}

