# -*- coding: utf-8 -*-
"""Tp4_YU_chenbao.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1MxiR5GQyX8ff2MCNvLLzf6Ks06i95BUH
"""

import numpy
import math
class Eratosthene:
  def __init__(self,n):
    self.n=n
    self.eratosthene(n)
    self.lprime=[i for i in range(2,n) if self.est_prime[i] == True]
    self.trace=[None]*(n+1)
    print(self.lprime)
    for i in range(2,n):
      if i in self.lprime:
        self.trace[i*i:n+1:i]=[i]*((n-i*i)//i +1)
    print(self.trace)
    pass
  def eratosthene(self,n):
    self.est_prime=[False]*2 + [True]*(n-1)
    for i in range(2,n):
        self.est_prime[i*i:n+1:i]=[False]*((n-i*i)//i +1)#Dans votre code écrit dans le tableau y a pas +1 , mais dans mon code sans +1 il ne marche plus
    
    print(self.est_prime)
  def est_nombre_premier(self,k):
      if k>len(self.est_prime):
        raise ValueError("le nombre k est trop grande!!")
      if k in self.lprime:
        print(str(k)+" est un nombre premier")
        return True
      else:
        print(sttr(k)+" n'est pas un nombre premier")
        return False
  def test_goldbach(self,n):
        pairs=[i+1 for i in range(3,n,2)]
        m={i+j:(i,j) for i in a.lprime for j in a.lprime}
        print([m[c] for c in pairs])
  def decomposition(self,k):
    if k>self.n:
      raise ValueError("Nombre est trop grand !!!")
    s=str(k)+"="
    while(self.trace[k] != None):
        s=s+str(self.trace[k])+"*"
        k=k//self.trace[k]
    s=s+str(k)#If faut ajouter str(k) , sinon le dernier facteur premier n'est pas pris en compte
    print(s)

a=Eratosthene(100)#[2, 3, 5, 7, 11, 13, 17, 19]
a.test_goldbach(20)#[(2, 2), (3, 3), (5, 3), (7, 3), (7, 5), (11, 3), (13, 3), (13, 5), (17, 3)]


a.decomposition(15)#15=3*5
#a.decomposition(154)#error, car k>n
a.decomposition(27)#27=3*3*3
a.decomposition(11)#11=11
#tests
#print(a.est_prime[17])#True
#print(a.est_prime[37])#True
#print(a.est_prime[97])#True
#print(a.est_prime[113])#True

#a.est_nombre_premier(97)
#a.est_nombre_premier(917)

#Code du cours
import numpy
r = numpy.random.rand(3, 7)
print(r)
print(type(r))

 # r[5,10]=0#index 5 is out of bounds for axis 0 with size 3

taille = r.shape
print(taille)#(3,7)
print(type(taille))#<class 'tuple'>

r = numpy.random.randint(0, 9, [5, 7])
s = numpy.random.randint(0, 9, [5, 7])
f = r+s

import cv2
from google.colab import files
!rm chien.jpg
#On fait l'envoie du fichier
uploaded=files.upload()#uploa pour l'image de chien

from google.colab.patches import cv2_imshow
im = cv2.imread('chien.jpg')
bleu, vert, rouge = im[100, 50]
cv2_imshow(im)
print(im.shape)#(421, 600, 3)
print(im.dtype)
print(f"La valeur de bleu du pixel (50, 50) est {im[50, 50, 0]}")
im[50, 50, 0] += 220
print(f"Après y avoir ajouté 220, la valeur de bleu du pixel (50, 50) est {im[50, 50,0]}")

im = cv2.imread('chien.jpg')
im2 = numpy.uint32(im)
print(im2.dtype)

uploaded=files.upload()#ps5

im2 = cv2.imread('ps5.png', cv2.IMREAD_GRAYSCALE)
print(im2.shape)#(400, 600)

class Image:
  def __init__(self,nom,bol=True):
    if bol ==True :
      self.im=cv2.imread(nom,0) 
    else:
      self.im = cv2.imread(nom)
    
  def imageshow(self):      
    cv2_imshow(self.im)

  def couler_noirblanc(self):
    R, G, B = self.im[:,:,0], self.im[:,:,1], self.im[:,:,2]
    self.im = 0.2989 * R + 0.5870 * G + 0.1140 * B
    self.imageshow()

a=Image("chien.jpg",False)
a.imageshow()
a.couler_noirblanc()
