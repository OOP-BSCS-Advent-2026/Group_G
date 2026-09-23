#### Phase Two
Phase Two implements a simple bookstore pricing system in Java. The program demonstrates object-oriented programming concepts such as:

- Inheritance
- Method overriding
- Polymorphism
- Encapsulation
- Input validation

The system calculates the total cost of bookstore items based on their prices, quantities, and applicable discount rules.

## Project Structure

| File | Description |
|---|---|
| `Item.java` | Base class representing a general bookstore item |
| `NoDiscountItem.java` | Represents an item sold without a discount |
| `PercentDiscountItem.java` | Applies a percentage discount when the quantity reaches a specified threshold |
| `FlatDiscountItem.java` | Applies a fixed amount discount when the quantity reaches a specified threshold |
| `Main.java` | Demonstrates the pricing system and prints a bookstore receipt |

## Class Description

### `Item`

`Item` is the parent class for all bookstore items.

It contains:

- Item name
- Item price
- A method for calculating the total cost

The class also validates that:

- The price must be greater than zero
- The quantity cannot be negative

### `NoDiscountItem`

`NoDiscountItem` extends `Item` and uses the standard price calculation without applying any discount.

```text
Total = price × quantity
```

### `PercentDiscountItem`

`PercentDiscountItem` extends `Item` and applies a percentage discount when the purchased quantity is equal to or greater than the specified threshold.

```text
Discounted Total = subtotal × (1 - discount percentage / 100)
```

For example, if an item costs UGX 2,000, the quantity is 10, and the discount is 10%:

```text
Subtotal = UGX 2,000 × 10 = UGX 20,000
Discounted Total = UGX 20,000 × 0.90 = UGX 18,000
```

### `FlatDiscountItem`

`FlatDiscountItem` extends `Item` and subtracts a fixed amount from the subtotal when the purchased quantity reaches the specified threshold.

```text
Discounted Total = subtotal - flat discount amount
```

The final total cannot be less than zero.

## Sample Items

The `Main` class demonstrates the following items:

| Item | Price | Quantity | Discount |
|---|---:|---:|---|
| Novel | UGX 15,000.00 | 2 | 5% discount from 3 items |
| Textbook | UGX 45,000.00 | 2 | No discount |
| Magazine | UGX 5,000.00 | 4 | UGX 1,000 discount from 5 items |
| Notebook | UGX 2,000.00 | 10 | 10% discount from 10 items |

The expected receipt total is:

```text
TOTAL = UGX 158,000.00
```

## How to Compile and Run

Open a terminal in the `Phase_Two` directory and compile the Java files:

```bash
javac *.java
```

Run the program using:

```bash
java Main
```

## Expected Output

```text
==== PAGETURNER BOOKSTORE ====
1. Novel UGX 15000.00
2. Textbook UGX 45000.00
3. Magazine UGX 5000.00
4. Notebook UGX 2000.00

==== RECEIPT ====
Novel x2 = UGX 30000.00
Textbook x2 = UGX 90000.00
Magazine x4 = UGX 20000.00
Notebook x10 = UGX 18000.00
---------------------------------------
TOTAL = UGX 158000.00
```

## Object-Oriented Programming Concepts Demonstrated

- **Inheritance:** Specialized item classes inherit from the `Item` class.
- **Polymorphism:** Different item types are stored in the same `Item[]` array and calculate totals according to their own implementations.
- **Method overriding:** Discount item classes override the `calculateTotal()` method.
- **Encapsulation:** Item properties are private and accessed through getter methods.
- **Validation:** Invalid prices and quantities are rejected using `IllegalArgumentException`.
