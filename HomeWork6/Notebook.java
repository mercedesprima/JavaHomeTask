package HomeWork6;

import java.util.Objects;

public class Notebook {
    public Notebook(String brand, int RAM, int HDD, String OS, String color, int price) {
        this.brand = brand;
        this.RAM = RAM;
        this.HDD = HDD;
        this.OS = OS;
        this.color = color;
        this.price = price;
    }
        String brand;
        int RAM;
        int HDD;
        String OS;
        String color;
        int price;

    public static Notebook createNotebook(String brand, int RAM, int HDD, String OS, String color, int price) {
        return new Notebook(brand, RAM, HDD, OS, color, price);
    }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("\n").append(brand + ", ").append(RAM + " Гб, " ).append(HDD + " Гб, ").append(OS + ", ")
                    .append(color + ", ").append(price + " рублей");
            return builder.toString();
        }

        @Override
        public int hashCode() {
            return Objects.hash(brand, RAM, HDD, OS, color, price);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Notebook nbook = (Notebook) obj;
            return brand.equals(nbook.brand) && RAM == nbook.RAM && HDD == nbook.HDD &&
                    OS.equals(nbook.OS) && color.equals(nbook.color) && price == nbook.price;
        }

    }

