func main()
  Create q Quad(10., 10., 60., 60.);
  Modify q Color(50, 50, 0);
  Modify q Color(255, 0, 0);
  Modify q Stroke(20,0, 255, 0, 1);
  Create e Circle(50., 650., 50.);
  Modify e Color(255, 0, 0);
  Modify e Stroke(30, 0, 0, 255, 0.5);
  Modify e Visibility(0.5);
  Modify e Size Radius(500.);
  Modify q Size Width(600.0);
  Modify q Size Height(600.0);
  //elipsis
  Create elip Elypse(200, 200, 200, 50);
  //poligon
  Create poli Polygon(200,10,250,190,160,210);
  Modify poli Color(0, 200, 100);
  //linia
  Create lin Line(600,50,650,200,800,60,810,30);
  //text
  Create tex Text(500,600,"OLA AMIGOS DE YUTUB");
endfunc
