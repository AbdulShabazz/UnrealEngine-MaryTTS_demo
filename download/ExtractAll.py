import os
import zipfile


# Extract all .zip files in the current directory
def main() -> None:
    # List of .zip files to be extracted
    zip_files = [
      "marytts-5.2.zip",
      "marytts-builder-5.2.zip",
      "marytts-master.zip",
      "voice-bits1-hsmm-5.2.zip",
      "voice-bits3-hsmm-5.2.zip",
      "voice-cmu-bdl-5.2.zip",
      "voice-cmu-bdl-hsmm-5.2.zip",
      "voice-cmu-nk-hsmm-5.2.zip",
      "voice-cmu-rms-5.2.zip",
      "voice-cmu-rms-hsmm-5.2.zip",
      "voice-cmu-slt-5.2.zip",
      "voice-dfki-obadiah-5.2.zip",
      "voice-dfki-obadiah-hsmm-5.2.zip",
      "voice-dfki-ot-5.2.zip",
      "voice-dfki-ot-hsmm-5.2.zip",
      "voice-dfki-pavoque-neutral-5.2.zip",
      "voice-dfki-pavoque-neutral-hsmm-5.2.zip",
      "voice-dfki-pavoque-styles-5.2.zip",
      "voice-dfki-poppy-5.2.zip",
      "voice-dfki-poppy-hsmm-5.2.zip",
      "voice-dfki-prudence-5.2.zip",
      "voice-dfki-prudence-hsmm-5.2.zip",
      "voice-dfki-spike-5.2.zip",
      "voice-dfki-spike-hsmm-5.2.zip",
      "voice-enst-camille-5.2.zip",
      "voice-enst-camille-hsmm-5.2.zip",
      "voice-enst-dennys-hsmm-5.2.zip",
      "voice-istc-lucia-hsmm-5.2.zip",
      "voice-marylux-lb-5.2.zip",
      "voice-upmc-jessica-5.2.zip",
      "voice-upmc-jessica-hsmm-5.2.zip",
      "voice-upmc-pierre-5.2.zip",
      "voice-upmc-pierre-hsmm-5.2.zip"
    ]

    # Current directory where the files are to be extracted
    current_directory = os.getcwd()

    # Loop through each .zip file and extract it
    for zip_file in zip_files:
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(current_directory)


if __name__ == "__main__":
    main()
