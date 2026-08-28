##### GroupG: Pageturner Bookstore

function calculateSubtotal(price, quantity, itemNumber)
    subtotal = price × quantity

    if itemNumber is 1 AND quantity >= 3 then
        subtotal = subtotal × 0.95
    else if itemNumber is 3 AND quantity >= 5 then
        subtotal = subtotal - 1000
    else if itemNumber is 4 AND quantity >= 10 then
        subtotal = subtotal × 0.90
    end if

    return subtotal
end function


function printReceipt(itemNames, quantities, subtotals)
    print "==== RECEIPT ===="

    for i = 0 TO 3 DO
        print itemNames[i], "x", quantities[i], "= UGX", subtotals[i]
    end for
end function


main program
    itemNames = ["Novel", "Textbook", "Magazine", "Notebook"]
    prices = [15000, 45000, 5000, 2000]
    quantities = [2, 2, 4, 10]

    print "==== PAGETURNER BOOKSTORE ===="
    for i = 0 TO 3 DO
        print (i + 1), itemNames[i], "UGX", prices[i]
    end for

    DECLARE subtotals array of size 4
    grandTotal = 0

    for i = 0 TO 3 DO
        subtotals[i] = calculateSubtotal(prices[i], quantities[i], i + 1)
        grandTotal = grandTotal + subtotals[i]
    end for

    call printReceipt(itemNames, quantities, subtotals)
    print "TOTAL = UGX", grandTotal

end program