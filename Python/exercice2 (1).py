# -*- coding: utf-8 -*-
"""Exercice2.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1wUIamwkbqzEznK8un6KLIxkCdTeED-xt
"""

from google.colab import files 
!rm liste_numeros.txt
uploaded=files.upload()

l = ['+','0','1','2','3','4','5','6','7','8','9'];
def format_phone_number(number):
  correct=False;
  Bon_format=[]
  numero=""
  numero2=""
  for i in number :
    if i in l:
      Bon_format=Bon_format+[i];
  if Bon_format[0:3]==["+","3","3"]:
    Bon_format=["0"]+Bon_format[3:]
  elif Bon_format[0:4]==["0","0","3","3"]:
    Bon_format=["0"]+Bon_format[4:]
  while '+' in Bon_format:
     Bon_format.remove('+')
  if len(Bon_format)!=10:
    return (False,None)
  elif Bon_format[0] != '0':
    return (False,None)
  for i in Bon_format:
    numero=numero+i
  for i in range(0,5):
    numero2=numero2+numero[2*i:2*i+2]+'-'
  numero2=numero2[0:14]
  print(numero2)
  return (True,numero2)
  
#Test
Numero1=format_phone_number("09 30 (804) 59")
Numero2=format_phone_number("09 30 (804) 591")
print(Numero1)
print(Numero2)

import csv
f = open("liste_numeros.txt", "r")
f=list(csv.reader(f,delimiter=':'))
g=[]
h=[]
print(len(f))
for i in f:
  inter=format_phone_number(i[1])
  if inter[0]==True:
    g.append(inter[1])

for i in f:
  if inter[1] in g:
    h.append(i[0])
 

j=list(zip(h,g))
print(len(j))