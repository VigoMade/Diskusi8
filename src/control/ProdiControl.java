/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import dao.ProdiDAO;
import entity.Prodi;

public class ProdiControl {
    private ProdiDAO pDao = new ProdiDAO();
    
    public void insertDataProdi(Prodi p) {
        pDao.insertProdi(p);
}


    public String showDataProdi() {

        List<Prodi> dataProdi = pDao.showProdi();

        String prodiString = "";

        for (int i=0; i < dataProdi.size(); i++) {
            prodiString = prodiString + dataProdi.get(i).getKodeProdi() + " || " 
                    + dataProdi.get(i).getNamaProdi() + "\n";
        }

        return prodiString;
    }
    public void updateDataProdi(Prodi p){
      pDao.updateProdi(p);
    }

    public void deleteDataProdi(String kodeprodi){
     pDao.deleteProdi(kodeprodi);
    }
    
    public Prodi searchDataProdi(String kodeprodi){
      Prodi searchProdi = pDao.searchProdi(kodeprodi);
      return searchProdi;
}

    
}
