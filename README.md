# ECG-signal-simulator
Cardiac signal simulation for biomedical analysis in Excel.

# 🫀 ECG Signal Simulator

![Java](https://img.shields.io/badge/Java-17-orange)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)
![Biomedical](https://img.shields.io/badge/Application-Biomedical-red)

A **Java console application** that simulates **electrocardiogram (ECG) signals** for biomedical analysis.  
Generates synthetic heartbeats at different rates (BPM) and exports data to **CSV** for graphing in **Excel, MATLAB, or Python**.

---

## 🎯 Features

- ✅ Simulate ECG signals at **45, 70, or 120 BPM** (bradycardia, normal, tachycardia).
- ✅ Adjustable **noise level** (0 = clean signal, 0.5 = noisy, 0.8 = very noisy).
- ✅ **Patient profiles** with clinical context (name, age, condition).
- ✅ Export data to **CSV format** (time, voltage) for external analysis.
- ✅ Clean, menu-driven console interface.

---

## 🧠 Logic & Concepts Applied

- **Mathematical modeling** of cardiac cycles (simplified QRS complex, T wave).
- **Object-Oriented Programming** (interfaces, inheritance, polymorphism).
- **Interfaces** (`Signal` interface for extensibility to EEG, EMG, etc.).
- **File I/O** (CSV export with metadata headers).
- **Noise simulation** (random noise + power line interference at 60 Hz).
- **Collections** (`ArrayList<double[]>` for signal storage).
