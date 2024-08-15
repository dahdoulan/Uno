package org.example;

public enum CardType {
    Regular{
        @Override
        public String toString() {
            return "Regular";
        }
    },
    DrawTwo{
        @Override
        public String toString() {
            return "DrawTwo";
        }
    },
    DrawFour{
        @Override
        public String toString() {
            return "DrawFour";
        }
    },
    Skip{
        @Override
        public String toString() {
            return "Skip";
        }
    },
    Reverse{
        @Override
        public String toString() {
            return "Reverse";
        }
    },
    ChangeColor{
        @Override
        public String toString() {
            return "ChangeColor";
        }
    }
}
