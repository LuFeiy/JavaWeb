package _4advanced.reflect;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RttiBack {

    abstract class Shape{
        void draw(){System.out.println(this + ".draw()");}
        abstract public String toString();
    }

    class Circle extends Shape {
        public String toString() {return "Circle";}
    }

    class Square extends Shape {
        public String toString() {return "Square";}
    }

    class Triangle extends Shape {
        public String toString() {return "Triangle";}
    }

    @Test
    public void test_01(){
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );
        for (Shape shape :shapeList) {
            shape.draw();
        }
    }


}
