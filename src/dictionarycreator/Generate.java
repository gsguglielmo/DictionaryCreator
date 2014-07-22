/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionarycreator;

import java.io.File;
import java.io.PrintWriter;
/**
 *
 * @author Guglielmo
 */
public class Generate extends Thread{
    int MaxSize,MeasureUnit,Lenght;
    String FileName;
    static String[] crke = new String[102];
    
    Generate(int rmaxSize,int rmeasureUnit,String rfileName,int rlenght)
    {
        MaxSize = rmaxSize;
        MeasureUnit = rmeasureUnit;
        Lenght = rlenght;
        FileName = rfileName;
    }
    private File f;
    long FinalWord=0;
    long CurrentWord = 0;
    @Override
    public void run()
    {
        int i;
        FinalWord = 102;
        System.out.println(Lenght);
        for(i=1;i<Lenght;i++)
        {
            FinalWord=FinalWord*102;
        }
        init();
        NewJFrame.jProgressBar2.setValue(0);
        NewJFrame.jProgressBar3.setValue(0);
        
        NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
        if(Lenght==1)Uno();
        if(Lenght==2)Due();
        if(Lenght==3)Tre();
        if(Lenght==4)Quattro();
        if(Lenght==5)Cinque();
        if(Lenght==6)Sei();
        if(Lenght==7)Sette();
        if(Lenght==8)Otto();
        if(Lenght==9)Nove();
        if(Lenght==10)Dieci();
        enable(true);
    }
    private void Uno()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i;
            for(i=0;i<102;i++)
            { 
                if(!NewJFrame.jCheckBox3.isSelected() && i==0)
                {}
                else
                {
                writer.println(crke[i]+"");
                CurrentWord++;
                NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                }
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101;     
                if(MaxSize <= GetFileDimension(f,MeasureUnit))
                {
                    System.out.println("NEW FILE");
                    f = new File(FileName+"-"+NumberOfFiles+".dic");
                    if(!f.exists())
                    {
                        f.createNewFile();
                    }
                    writer.close();
                    writer = new PrintWriter(f);
                    NumberOfFiles++;
                }
                NewJFrame.jProgressBar2.setValue(i+1);
                NewJFrame.jProgressBar3.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Due()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    writer.println(crke[i]+crke[j]+""); 
                    CurrentWord++;
                    NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                    if(MaxSize <= GetFileDimension(f,MeasureUnit))
                    {
                        System.out.println("NEW FILE");
                        f = new File(FileName+"-"+NumberOfFiles+".dic");
                        if(!f.exists())
                        {
                            f.createNewFile();
                        }
                        writer.close();
                        writer = new PrintWriter(f);
                        NumberOfFiles++;
                    }
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101;   
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Tre()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j,k;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    for(k=0;k<102;k++)
                    {
                        writer.println(crke[i]+crke[j]+crke[k]+"");
                        CurrentWord++;
                        NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                            if(!NewJFrame.jCheckBox4.isSelected() && k==0)k=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && k==10)k=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && k==41)k=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && k==75)k=101;
                            
                    }
                    
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                    if(MaxSize <= GetFileDimension(f,MeasureUnit))
                            {
                                System.out.println("NEW FILE");
                                f = new File(FileName+"-"+NumberOfFiles+".dic");
                                if(!f.exists())
                                {
                                    f.createNewFile();
                                }
                                writer.close();
                                writer = new PrintWriter(f);
                                NumberOfFiles++;
                            }
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101;   
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Quattro()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j,k,l,m;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    for(k=0;k<102;k++)
                    {
                        for(l=0;l<102;l++)
                        {
                            writer.println(crke[i]+crke[j]+crke[k]+crke[l]+"");
                            CurrentWord++;
                            NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                            if(!NewJFrame.jCheckBox4.isSelected() && l==0)l=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && l==10)l=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && l==41)l=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && l==75)l=101;
                            
                        }
                        if(!NewJFrame.jCheckBox4.isSelected() && k==0)k=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && k==10)k=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && k==41)k=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && k==75)k=101;
                    }
                    if(MaxSize <= GetFileDimension(f,MeasureUnit))
                            {
                                System.out.println("NEW FILE");
                                f = new File(FileName+"-"+NumberOfFiles+".dic");
                                if(!f.exists())
                                {
                                    f.createNewFile();
                                }
                                writer.close();
                                writer = new PrintWriter(f);
                                NumberOfFiles++;
                            }
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101;   
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Cinque()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j,k,l,m;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    for(k=0;k<102;k++)
                    {
                        for(l=0;l<102;l++)
                        {
                            for(m=0;m<102;m++)
                            {
                                writer.println(crke[i]+crke[j]+crke[k]+crke[l]+crke[m]+"");
                                CurrentWord++;
                                NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                                if(!NewJFrame.jCheckBox4.isSelected() && m==0)m=10;
                                if(!NewJFrame.jCheckBox2.isSelected() && m==10)m=41;
                                if(!NewJFrame.jCheckBox3.isSelected() && m==41)m=75;
                                if(!NewJFrame.jCheckBox1.isSelected() && m==75)m=101; 
                                
                            }
                            if(!NewJFrame.jCheckBox4.isSelected() && l==0)l=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && l==10)l=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && l==41)l=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && l==75)l=101; 
                        } 
                        if(!NewJFrame.jCheckBox4.isSelected() && k==0)k=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && k==10)k=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && k==41)k=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && k==75)k=101; 
                            if(MaxSize <= GetFileDimension(f,MeasureUnit))
                                {
                                    System.out.println("NEW FILE");
                                    f = new File(FileName+"-"+NumberOfFiles+".dic");
                                    if(!f.exists())
                                    {
                                        f.createNewFile();
                                    }
                                    writer.close();
                                    writer = new PrintWriter(f);
                                    NumberOfFiles++;
                                }
                    }
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101;   
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Sei()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j,k,l,m,n;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    for(k=0;k<102;k++)
                    {
                        for(l=0;l<102;l++)
                        {
                            for(m=0;m<102;m++)
                            {
                                for(n=0;n<102;n++)
                                {
                                    writer.println(crke[i]+crke[j]+crke[k]+crke[l]+crke[m]+crke[n]+"");
                                    CurrentWord++;
                                    NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                                    if(!NewJFrame.jCheckBox4.isSelected() && n==0)n=10;
                                    if(!NewJFrame.jCheckBox2.isSelected() && n==10)n=41;
                                    if(!NewJFrame.jCheckBox3.isSelected() && n==41)n=75;
                                    if(!NewJFrame.jCheckBox1.isSelected() && n==75)n=101; 
                                    
                                }
                                if(!NewJFrame.jCheckBox4.isSelected() && m==0)m=10;
                                if(!NewJFrame.jCheckBox2.isSelected() && m==10)m=41;
                                if(!NewJFrame.jCheckBox3.isSelected() && m==41)m=75;
                                if(!NewJFrame.jCheckBox1.isSelected() && m==75)m=101;     
                            }
                            if(MaxSize <= GetFileDimension(f,MeasureUnit))
                                    {
                                        System.out.println("NEW FILE");
                                        f = new File(FileName+"-"+NumberOfFiles+".dic");
                                        if(!f.exists())
                                        {
                                            f.createNewFile();
                                        }
                                        writer.close();
                                        writer = new PrintWriter(f);
                                        NumberOfFiles++;
                                    }
                            if(!NewJFrame.jCheckBox4.isSelected() && l==0)l=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && l==10)l=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && l==41)l=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && l==75)l=101; 
                        } 
                    }
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101;   
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Sette()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j,k,l,m,n,o;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    for(k=0;k<102;k++)
                    {
                        for(l=0;l<102;l++)
                        {
                            for(m=0;m<102;m++)
                            {
                                for(n=0;n<102;n++)
                                {
                                    for(o=0;o<102;o++)
                                    {
                                        writer.println(crke[i]+crke[j]+crke[k]+crke[l]+crke[m]+crke[n]+crke[o]+"");
                                        CurrentWord++;
                                        NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                                        if(!NewJFrame.jCheckBox4.isSelected() && o==0)o=10;
                                        if(!NewJFrame.jCheckBox2.isSelected() && o==10)o=41;
                                        if(!NewJFrame.jCheckBox3.isSelected() && o==41)o=75;
                                        if(!NewJFrame.jCheckBox1.isSelected() && o==75)o=101; 
                                        
                                    }
                                    if(!NewJFrame.jCheckBox4.isSelected() && n==0)n=10;
                                    if(!NewJFrame.jCheckBox2.isSelected() && n==10)n=41;
                                    if(!NewJFrame.jCheckBox3.isSelected() && n==41)n=75;
                                    if(!NewJFrame.jCheckBox1.isSelected() && n==75)n=101; 
                                }
                                if(!NewJFrame.jCheckBox4.isSelected() && m==0)m=10;
                                if(!NewJFrame.jCheckBox2.isSelected() && m==10)m=41;
                                if(!NewJFrame.jCheckBox3.isSelected() && m==41)m=75;
                                if(!NewJFrame.jCheckBox1.isSelected() && m==75)m=101;     
                            }
                            if(MaxSize <= GetFileDimension(f,MeasureUnit))
                                        {
                                            System.out.println("NEW FILE");
                                            f = new File(FileName+"-"+NumberOfFiles+".dic");
                                            if(!f.exists())
                                            {
                                                f.createNewFile();
                                            }
                                            writer.close();
                                            writer = new PrintWriter(f);
                                            NumberOfFiles++;
                                        }
                            if(!NewJFrame.jCheckBox4.isSelected() && l==0)l=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && l==10)l=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && l==41)l=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && l==75)l=101; 
                        } 
                    }
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101; 
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Otto()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j,k,l,m,n,o,h;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    for(k=0;k<102;k++)
                    {
                        for(l=0;l<102;l++)
                        {
                            for(m=0;m<102;m++)
                            {
                                for(n=0;n<102;n++)
                                {
                                    for(o=0;o<102;o++)
                                    {
                                        for(h=0;h<102;h++)
                                        {
                                            writer.println(crke[i]+crke[j]+crke[k]+crke[l]+crke[m]+crke[n]+crke[o]+crke[h]+"");
                                            CurrentWord++;
                                            NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                                            if(!NewJFrame.jCheckBox4.isSelected() && h==0)h=10;
                                            if(!NewJFrame.jCheckBox2.isSelected() && h==10)h=41;
                                            if(!NewJFrame.jCheckBox3.isSelected() && h==41)h=75;
                                            if(!NewJFrame.jCheckBox1.isSelected() && h==75)h=101; 
                                            
                                        }
                                        if(!NewJFrame.jCheckBox4.isSelected() && o==0)o=10;
                                        if(!NewJFrame.jCheckBox2.isSelected() && o==10)o=41;
                                        if(!NewJFrame.jCheckBox3.isSelected() && o==41)o=75;
                                        if(!NewJFrame.jCheckBox1.isSelected() && o==75)o=101; 
                                    }
                                    if(!NewJFrame.jCheckBox4.isSelected() && n==0)n=10;
                                    if(!NewJFrame.jCheckBox2.isSelected() && n==10)n=41;
                                    if(!NewJFrame.jCheckBox3.isSelected() && n==41)n=75;
                                    if(!NewJFrame.jCheckBox1.isSelected() && n==75)n=101;
                                    if(MaxSize <= GetFileDimension(f,MeasureUnit))
                                            {
                                                System.out.println("NEW FILE");
                                                f = new File(FileName+"-"+NumberOfFiles+".dic");
                                                if(!f.exists())
                                                {
                                                    f.createNewFile();
                                                }
                                                writer.close();
                                                writer = new PrintWriter(f);
                                                NumberOfFiles++;
                                            }
                                }
                                if(!NewJFrame.jCheckBox4.isSelected() && m==0)m=10;
                                if(!NewJFrame.jCheckBox2.isSelected() && m==10)m=41;
                                if(!NewJFrame.jCheckBox3.isSelected() && m==41)m=75;
                                if(!NewJFrame.jCheckBox1.isSelected() && m==75)m=101;     
                            }
                            if(!NewJFrame.jCheckBox4.isSelected() && l==0)l=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && l==10)l=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && l==41)l=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && l==75)l=101; 
                        } 
                    }
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101; 
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Nove()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j,k,l,m,n,o,h,g;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    for(k=0;k<102;k++)
                    {
                        for(l=0;l<102;l++)
                        {
                            for(m=0;m<102;m++)
                            {
                                for(n=0;n<102;n++)
                                {
                                    for(o=0;o<102;o++)
                                    {
                                        for(h=0;h<102;h++)
                                        {
                                            for(g=0;g<102;g++)
                                            {
                                                writer.println(crke[i]+crke[j]+crke[k]+crke[l]+crke[m]+crke[n]+crke[o]+crke[h]+crke[g]+"");
                                                CurrentWord++;
                                                NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                                                if(!NewJFrame.jCheckBox4.isSelected() && g==0)g=10;
                                                if(!NewJFrame.jCheckBox2.isSelected() && g==10)g=41;
                                                if(!NewJFrame.jCheckBox3.isSelected() && g==41)g=75;
                                                if(!NewJFrame.jCheckBox1.isSelected() && g==75)g=101; 
                                                
                                            }
                                            if(!NewJFrame.jCheckBox4.isSelected() && h==0)h=10;
                                            if(!NewJFrame.jCheckBox2.isSelected() && h==10)h=41;
                                            if(!NewJFrame.jCheckBox3.isSelected() && h==41)h=75;
                                            if(!NewJFrame.jCheckBox1.isSelected() && h==75)h=101; 
                                        }
                                        if(!NewJFrame.jCheckBox4.isSelected() && o==0)o=10;
                                        if(!NewJFrame.jCheckBox2.isSelected() && o==10)o=41;
                                        if(!NewJFrame.jCheckBox3.isSelected() && o==41)o=75;
                                        if(!NewJFrame.jCheckBox1.isSelected() && o==75)o=101; 
                                    }
                                    
                                    if(!NewJFrame.jCheckBox4.isSelected() && n==0)n=10;
                                    if(!NewJFrame.jCheckBox2.isSelected() && n==10)n=41;
                                    if(!NewJFrame.jCheckBox3.isSelected() && n==41)n=75;
                                    if(!NewJFrame.jCheckBox1.isSelected() && n==75)n=101; 
                                }
                                if(!NewJFrame.jCheckBox4.isSelected() && m==0)m=10;
                                if(!NewJFrame.jCheckBox2.isSelected() && m==10)m=41;
                                if(!NewJFrame.jCheckBox3.isSelected() && m==41)m=75;
                                if(!NewJFrame.jCheckBox1.isSelected() && m==75)m=101;     
                            }
                            if(MaxSize <= GetFileDimension(f,MeasureUnit))
                                                {
                                                    System.out.println("NEW FILE");
                                                    f = new File(FileName+"-"+NumberOfFiles+".dic");
                                                    if(!f.exists())
                                                    {
                                                        f.createNewFile();
                                                    }
                                                    writer.close();
                                                    writer = new PrintWriter(f);
                                                    NumberOfFiles++;
                                                }
                            if(!NewJFrame.jCheckBox4.isSelected() && l==0)l=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && l==10)l=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && l==41)l=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && l==75)l=101; 
                        } 
                    }
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101; 
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    private void Dieci()
    {
        f = new File(FileName+".dic");
        NewJFrame.jProgressBar2.setMaximum(102);
        NewJFrame.jProgressBar3.setMaximum(102);
        try
        {
            PrintWriter writer = new PrintWriter(f);
            int NumberOfFiles = 1;
            int i,j,k,l,m,n,o,h,g,d;
            for(i=0;i<102;i++)
            { 
                for(j=0;j<102;j++)
                {
                    for(k=0;k<102;k++)
                    {
                        for(l=0;l<102;l++)
                        {
                            for(m=0;m<102;m++)
                            {
                                for(n=0;n<102;n++)
                                {
                                    for(o=0;o<102;o++)
                                    {
                                        for(h=0;h<102;h++)
                                        {
                                            for(g=0;g<102;g++)
                                            {
                                                for(d=0;d<102;d++)
                                                {
                                                    writer.println(crke[i]+crke[j]+crke[k]+crke[l]+crke[m]+crke[n]+crke[o]+crke[h]+crke[g]+crke[d]+"");
                                                    CurrentWord++;
                                                    NewJFrame.jLabel7.setText(CurrentWord+"/"+FinalWord);
                                                    if(!NewJFrame.jCheckBox4.isSelected() && d==0)d=10;
                                                    if(!NewJFrame.jCheckBox2.isSelected() && d==10)d=41;
                                                    if(!NewJFrame.jCheckBox3.isSelected() && d==41)d=75;
                                                    if(!NewJFrame.jCheckBox1.isSelected() && d==75)d=101; 
                                                    
                                                }
                                                if(!NewJFrame.jCheckBox4.isSelected() && g==0)g=10;
                                                if(!NewJFrame.jCheckBox2.isSelected() && g==10)g=41;
                                                if(!NewJFrame.jCheckBox3.isSelected() && g==41)g=75;
                                                if(!NewJFrame.jCheckBox1.isSelected() && g==75)g=101; 
                                            }
                                            if(!NewJFrame.jCheckBox4.isSelected() && h==0)h=10;
                                            if(!NewJFrame.jCheckBox2.isSelected() && h==10)h=41;
                                            if(!NewJFrame.jCheckBox3.isSelected() && h==41)h=75;
                                            if(!NewJFrame.jCheckBox1.isSelected() && h==75)h=101; 
                                        }
                                        if(!NewJFrame.jCheckBox4.isSelected() && o==0)o=10;
                                        if(!NewJFrame.jCheckBox2.isSelected() && o==10)o=41;
                                        if(!NewJFrame.jCheckBox3.isSelected() && o==41)o=75;
                                        if(!NewJFrame.jCheckBox1.isSelected() && o==75)o=101; 
                                        
                                    }
                                    if(!NewJFrame.jCheckBox4.isSelected() && n==0)n=10;
                                    if(!NewJFrame.jCheckBox2.isSelected() && n==10)n=41;
                                    if(!NewJFrame.jCheckBox3.isSelected() && n==41)n=75;
                                    if(!NewJFrame.jCheckBox1.isSelected() && n==75)n=101; 
                                }
                                if(MaxSize <= GetFileDimension(f,MeasureUnit))
                                                    {
                                                        System.out.println("NEW FILE");
                                                        f = new File(FileName+"-"+NumberOfFiles+".dic");
                                                        if(!f.exists())
                                                        {
                                                           f.createNewFile();
                                                        }
                                                        writer.close();
                                                        writer = new PrintWriter(f);
                                                        NumberOfFiles++;
                                                    }
                                if(!NewJFrame.jCheckBox4.isSelected() && m==0)m=10;
                                if(!NewJFrame.jCheckBox2.isSelected() && m==10)m=41;
                                if(!NewJFrame.jCheckBox3.isSelected() && m==41)m=75;
                                if(!NewJFrame.jCheckBox1.isSelected() && m==75)m=101;     
                            }
                            if(!NewJFrame.jCheckBox4.isSelected() && l==0)l=10;
                            if(!NewJFrame.jCheckBox2.isSelected() && l==10)l=41;
                            if(!NewJFrame.jCheckBox3.isSelected() && l==41)l=75;
                            if(!NewJFrame.jCheckBox1.isSelected() && l==75)l=101; 
                        } 
                    }
                    
                    if(!NewJFrame.jCheckBox4.isSelected() && j==0)j=10;
                    if(!NewJFrame.jCheckBox2.isSelected() && j==10)j=41;
                    if(!NewJFrame.jCheckBox3.isSelected() && j==41)j=75;
                    if(!NewJFrame.jCheckBox1.isSelected() && j==75)j=101; 
                    NewJFrame.jProgressBar3.setValue(j+1);
                }
                
                if(!NewJFrame.jCheckBox4.isSelected() && i==0)i=10;
                if(!NewJFrame.jCheckBox2.isSelected() && i==10)i=41;
                if(!NewJFrame.jCheckBox3.isSelected() && i==41)i=75;
                if(!NewJFrame.jCheckBox1.isSelected() && i==75)i=101;   
                NewJFrame.jProgressBar2.setValue(i+1);
            }
            writer.close();
        }
        catch(Exception napaka)
        {
            System.out.println("ERROR");
        }
    }
    
    private long GetFileDimension(File ff,int measure)
    {
        long dim = ff.length();
        switch(measure)
        {
            case 0:
                dim = dim /1000;
                return dim;
            case 1:
                dim = dim /1000;
                dim = dim /1000;
                return dim;
            case 2:
                dim = dim /1000;
                dim = dim /1000;
                dim = dim /1000;
                return dim;
        }
        return -1;
    }
    private void init()
    {
        crke[0] = ""; // \\
        crke[1] = "1";  //NUMERI
        crke[2] = "2";
        crke[3] = "3";
        crke[4] = "4";
        crke[5] = "5";
        crke[6] = "6";
        crke[7] = "7";
        crke[8] = "8";
        crke[9] = "9";
        crke[10] = "0";
        crke[11] = "ì"; //LETTERE
        crke[12] = "q";
        crke[13] = "w";
        crke[14] = "e";
        crke[15] = "r";
        crke[16] = "t";
        crke[17] = "y";
        crke[18] = "u";
        crke[19] = "i";
        crke[20] = "o";
        crke[21] = "p";
        crke[22] = "è";
        crke[23] = "a";
        crke[24] = "s";
        crke[25] = "d";
        crke[26] = "f";
        crke[27] = "g";
        crke[28] = "h";
        crke[29] = "j";
        crke[30] = "k";
        crke[31] = "l";
        crke[32] = "ò";
        crke[33] = "à";
        crke[34] = "ù";    
        crke[35] = "z";
        crke[36] = "x";
        crke[37] = "c";
        crke[38] = "v";
        crke[39] = "b";
        crke[40] = "n";
        crke[41] = "m";
        crke[42] = "+"; //SIMBOLI
        crke[43] = "<";
        crke[44] = ",";  
        crke[45] = ".";
        crke[46] = "-";
        crke[47] = "'";
        crke[48] = "|";
        crke[49] = "!";
        crke[50] = "\"";
        crke[51] = "£";
        crke[52] = "$";
        crke[53] = "%";
        crke[54] = "&";
        crke[55] = "/";
        crke[56] = "(";
        crke[57] = ")";
        crke[58] = "=";
        crke[59] = "?";
        crke[60] = "€";
        crke[61] = "é";
        crke[62] = "*";
        crke[63] = "[";
        crke[64] = "]";
        crke[65] = "{";
        crke[66] = "}";
        crke[67] = "ç";
        crke[68] = "@";
        crke[69] = "°";
        crke[70] = "#";
        crke[71] = "§";
        crke[72] = ">";
        crke[73] = ";";
        crke[74] = ":";
        crke[75] = "_";  
        crke[76] = "Q"; //MAIUSCOLE
        crke[77] = "W"; 
        crke[78] = "E"; 
        crke[79] = "R"; 
        crke[80] = "T"; 
        crke[81] = "Y"; 
        crke[82] = "U"; 
        crke[83] = "I"; 
        crke[84] = "O"; 
        crke[85] = "P"; 
        crke[86] = "A"; 
        crke[87] = "S"; 
        crke[88] = "D"; 
        crke[89] = "F"; 
        crke[90] = "G"; 
        crke[91] = "H"; 
        crke[92] = "J"; 
        crke[93] = "K"; 
        crke[94] = "L"; 
        crke[95] = "Z"; 
        crke[96] = "X"; 
        crke[97] = "C"; 
        crke[98] = "V"; 
        crke[99] = "B"; 
        crke[100] = "N"; 
        crke[101] = "M"; 
        
        
        
        
    }
    public void enable(boolean en)
    {
        NewJFrame.jButton1.setEnabled(en);
        NewJFrame.jCheckBox1.setEnabled(en);
        NewJFrame.jCheckBox2.setEnabled(en);
        NewJFrame.jCheckBox3.setEnabled(en);
        NewJFrame.jCheckBox4.setEnabled(en);
        NewJFrame.jTextField1.setEnabled(en);
        NewJFrame.jTextField2.setEnabled(en);
        NewJFrame.jSpinner1.setEnabled(en);
    }
    
    public void ciaopippo()
    {
        
        System.out.println("Hello");
    }
}
