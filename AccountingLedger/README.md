# The Good Account ☁️

*A Good Place–inspired Java accounting ledger application*

## Project Overview

**The Good Account** is a command-line accounting ledger application built in Java. It lets users record money coming in and going out, review transaction history, and generate reports to better understand their financial activity.

The application uses a playful, *The Good Place*–inspired theme, including custom menu messages and terminal colors, while practicing core Java concepts such as classes, objects, collections, file handling, loops, conditionals, exception handling, and date/time operations.

## What the Application Does

- **Add deposits:** Record money received as a positive transaction.
- **Record payments:** Record money spent as a negative transaction.
- **View the ledger:** Display all transactions, deposits only, or payments only.
- **Generate date-based reports:** View Month to Date, Previous Month, Year to Date, or Previous Year transactions.
- **Search by vendor:** Find transactions by a full or partial vendor name, regardless of capitalization.
- **Sort transactions:** Display entries from newest to oldest, using transaction time to order entries on the same date.
- **Save transactions:** Append new records to a CSV file so data remains available between runs.

## How to Use It

1. Run the Java application.
2. On the home screen, choose an option:
   - **D — Add Deposit:** Enter a description, vendor, and amount.
   - **P — Make Payment:** Enter a description, vendor, and amount.
   - **L — Ledger:** Open the transaction history and reports.
   - **X — Exit:** Close the application.
3. In the **Ledger** menu, choose to view all transactions, deposits, payments, reports, or return home.
4. In **Reports**, select one of the available date-based reports or search by vendor.

Dates and times are captured automatically when a new transaction is entered. Deposits are stored as positive amounts and payments as negative amounts.

## Reports

| Report | What it displays |
| --- | --- |
| Month to Date | Transactions from the first day of the current month through today |
| Previous Month | Transactions from the first through the last day of the preceding month |
| Year to Date | Transactions from January 1 of the current year through today |
| Previous Year | Transactions from January 1 through December 31 of the preceding year |
| Search by Vendor | Transactions whose vendor contains the search text, ignoring capitalization |

An empty vendor search is rejected with a helpful message. When a vendor search has no matches, the application displays a “No Transactions Found” message.

## Project Structure and Main Methods

### `Transaction` class
Represents a single ledger entry with a date, time, description, vendor, and amount. Its getter methods allow other parts of the application to read those values.

### `FileManager` class
- **`readTransaction()`** — Reads the pipe-delimited transaction file, converts valid rows into `Transaction` objects, and returns a `List<Transaction>`. Malformed rows are handled so the remaining rows can still be processed.
- **`writeTransaction(Transaction transaction)`** — Appends a transaction to the CSV file.

### `TheGoodAccount` class
- **`main(...)`** — Runs the home menu and directs users to the selected feature.
- **`addTransaction(String transactionType, Scanner scanner)`** — Collects the transaction details, makes deposits positive and payments negative, creates a `Transaction`, and saves it through `FileManager`.
- **`displayLedger(Scanner scanner)`** — Displays the ledger menu and transaction lists.
- **`displayReports(Scanner scanner)`** — Displays the reports menu and processes report selections.
- **`filterByDate(List<Transaction> transactions, LocalDate startDate, LocalDate endDate)`** — Prints transactions within the selected date range, including both boundary dates.
- **`sortTransactions(List<Transaction> transactions)`** — Sorts transactions from newest to oldest by date and then time. The same helper is reused in the ledger and reports.

## Transaction File Format

Transactions are stored in `transactions.csv` as pipe-separated values:

```text
date|time|description|vendor|amount
```

Example data row:

```text
2026-11-02|20:35:56|Streaming Subscription|Example Service|-25.00
```

- **Date:** `yyyy-MM-dd`
- **Time:** `HH:mm:ss`
- **Description:** What the transaction was for
- **Vendor:** Who the transaction involved
- **Amount:** Positive for deposits, negative for payments

The format line above illustrates the column order; the transaction file does not require a header row.

## Input Validation and Error Handling

- Invalid numeric amounts are caught with `NumberFormatException` so the application can show a message instead of crashing.
- Empty or whitespace-only vendor searches are rejected.
- Unrecognized Reports menu selections display a themed error message.
- Searches with no matching vendors display a clear no-results message.
- Malformed transaction-file rows are handled while reading.

## Technologies and Concepts

- Java
- Object-oriented programming (classes and objects)
- `List<Transaction>` collections and enhanced `for` loops
- `Scanner` for console input
- CSV file reading and writing
- `LocalDate`, `LocalTime`, and `DateTimeFormatter`
- Lambdas and `List.sort()`
- `try-catch` exception handling
- Reusable helper methods

## Running the Application

Open the project in a Java IDE, ensure the project is configured with a compatible Java JDK, and run the `main` method in `TheGoodAccount.java`. Keep the transaction data file at the path expected by `FileManager`.

> **Note:** The exact Java version, build command, and data-file path depend on the project's local configuration.

## Planned Enhancement: Custom Search

The next feature will add **6 — Custom Search** to the Reports menu. It will let users optionally filter transactions by:

- Start Date
- End Date
- Description
- Vendor
- Amount

Fields left blank will not restrict the results. This feature is **planned, not yet implemented**.

## Theme and Design

Inspired by *The Good Place*, the application uses the name **The Good Account**, friendly messages such as “Wonderful choice! I've got that right here,” themed error prompts such as “OH, DIP!”, and custom console colors to make a traditional accounting ledger more engaging.

---

*The Good Account — keeping track of the good coming in and going out.*
