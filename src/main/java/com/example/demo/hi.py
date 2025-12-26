#!/usr/bin/env python3

import os
import shutil
import time

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SOURCE_DIR = os.path.join(BASE_DIR, "src", "test")
DEST_DIR = "/home/coder/Workspace/test_saved"

while True:
    try:
        if not os.path.isdir(SOURCE_DIR):
            print("Source folder not found")
        else:
            os.makedirs(DEST_DIR, exist_ok=True)

            # Copy only contents, not the folder itself
            for item in os.listdir(SOURCE_DIR):
                src_path = os.path.join(SOURCE_DIR, item)
                dest_path = os.path.join(DEST_DIR, item)

                if os.path.isdir(src_path):
                    shutil.copytree(src_path, dest_path, dirs_exist_ok=True)
                else:
                    shutil.copy2(src_path, dest_path)

            print("Folder Captured!")

    except Exception as e:
        print(f"Error: {e}")

    time.sleep(1)
