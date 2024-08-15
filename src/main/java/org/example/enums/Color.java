package org.example.enums;

public enum Color {
    RED {
        @Override
        public String toString() {
            return "Red";
        }
    },
    GREEN {
        @Override
        public String toString() {
            return "Green";
        }
    },
    BLUE {
        @Override
        public String toString() {
            return "Blue";
        }
    },
    YELLOW {
        @Override
        public String toString() {
            return "Yellow";
        }
    },
    WILDCARD{
        @Override
        public String toString() {
            return "WildCard";
        }
    }
}
