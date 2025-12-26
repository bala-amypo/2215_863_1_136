#!/usr/bin/env python3

import os
import shutil
import time

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SOURCE_DIR = os.path.join(BASE_DIR, "src", "test")
DEST_DIR = "/home/coder/Workspace/test_saved"

def copy_if_changed(src, dest):
    if not os.path.exists(dest):
        shutil.copy2(src, dest)
        return

    if os.path.getmtime(src) > os.path.getmtime(dest):
        shutil.copy2(src, dest)

while True:
    try:
        if not os.path.isdir(SOURCE_DIR):
            print("Source folder not found")
        else:
            os.makedirs(DEST_DIR, exist_ok=True)

            for root, dirs, files in os.walk(SOURCE_DIR):
                rel_path = os.path.relpath(root, SOURCE_DIR)
                target_root = os.path.join(DEST_DIR, rel_path)
                os.makedirs(target_root, exist_ok=True)

                for file in files:
                    src_file = os.path.join(root, file)
                    dest_file = os.path.join(target_root, file)
                    copy_if_changed(src_file, dest_file)

            print("Folder synced")

    except Exception as e:
        print(f"Error: {e}")

    time.sleep(1)
