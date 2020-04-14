package acesskeyfrompdf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class testwrite {

    
    public static void main(String[] args) throws IOException {
        
        
        
    }
    
    public boolean consultachaves(String caminhopdf, String caminhotxt, String chave) throws IOException{
        //com.mycompany.mavenproject1.frame frame = new com.mycompany.mavenproject1.frame();
                
        int ind;
        String temp;
       
        File myFile = new File(caminhopdf);
        
        
        try (PDDocument doc = PDDocument.load(myFile)) {

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(doc);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            //System.out.println(dateFormat.format(date));
            try (FileWriter writer = new FileWriter(caminhotxt +".txt", true)
            //System.out.println("Text size: " + text.length() + " characters:");
            //System.out.println(text);
            //System.out.println("Posicao da chave: " +text.indexOf("3520"));
            //ind = text.indexOf("3520");
            //System.out.println("Chave: " +text.substring(ind, ind+64).replace(" ", ""));
            ) {     writer.write(dateFormat.format(date));
                    writer.write("\r\n");
                    if(!text.contains(chave+" ")){
                    writer.write("Nao foi encontrada Danfe com chave de acesso iniciada em ''" + chave +"''");
                    writer.write("\r\n");
                    JOptionPane.showMessageDialog(null,"Nao foi encontrada nenhuma chave.");
                    return false;}                    
                while(text.contains(chave+" ")){
                    ind = text.indexOf(chave+" ");
                    System.out.println(text.substring(ind, ind+64).replace(" ", ""));
                    temp = text.substring(ind, ind+64);
                    System.out.println("temp = " + temp);
                    String replace = text.replace(temp, "chavedeacesso");
                    text = replace;
                    String replace1 = temp.replace(" ", "");
                    if(validarchave(replace1)){
                    writer.write(replace1);
                    writer.write("\r\n");}
                    //System.out.println(validarchave(replace1) + " = dv.");
                    //text.substring(ind, ind+64).replace(" ", "");
                }   
                writer.write("\r\n");
                writer.close();
                
            }
            
            
            
        }
        
        return true;
    
    }
    
    public boolean validarchave(String chave){
   
        
    for(int i = 0; i < chave.length(); i++){
    //System.out.println("char "+ i + " = " + chave.charAt(i));
    //dv = chave.charAt(43);
    
    }    
        
    char dv;
    int soma, i, r, num, peso;
    soma = 0;
    peso = 2;
    
    for (i=42; i>=0; i--) {
    
    num = (int)(chave.charAt(i) - 48);
    //System.out.println("num = "+ num);
    soma = soma + (num * peso);
    peso = peso + 1;
      if (peso == 10) peso = 2;
      if (peso == 0) peso = 9;
      }
    
      
    
    r = soma % 11;
      if ((r == 0) || (r == 1))
         dv = '0';
      else dv = (char)((11-r) + 48);
    
    if(dv == chave.charAt(43)){
    return true;
    
    } else { 
    return false;}
    
    
    
    }
}
