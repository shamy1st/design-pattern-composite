
# Composite Design Pattern (Java Implementation)

**Composite** describes a group of objects that are treated the same way as a single instance. ([wiki](https://en.wikipedia.org/wiki/Composite_pattern))
![](https://github.com/shamy1st/design-pattern-composite-java/blob/main/composite-uml.png)
### Problem: 
You have **Shape** (Square, Circle, ...) and **Group** of shapes and you want to treat **Group** like a **Shape** at any operation like (render, draw, resize, ...).

The issue with this implementation that in **Group** class each time you want to add new operation you need to cast the **Object** to its type.

    public class Main {
        public static void main(String[] args) {
            Group group1 = new Group();
            group1.add(new Shape());	//square
            group1.add(new Shape());	//square
            
            Group group2 = new Group();
            group2.add(new Shape());	//circle
            group2.add(new Shape());	//circle
            
            Group group = new Group();
            group.add(group1);
            group.add(group2);
            
            group.render();
        }
    }

    public class Shape {
        public void render() {
            System.out.println("Render Shape");
        }
    }

    public class Group implements Component {
        private List<Object> objects = new ArrayList<>();
        
        public void add(Object shape) {
            objects.add(shape);
        }
        
        public void render() {
            for(var object : objects) {
                if(object instanceof Shape) {
                    ((Shape)object).render();
                } else {
                    ((Group)object).render();
                }
            }
        }
    }
### Solution:
![](https://github.com/shamy1st/design-pattern-composite-java/blob/main/composite-solution-uml.png)
