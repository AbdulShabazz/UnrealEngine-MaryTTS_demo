"""An example of how to encode two stereo sources into a .wav file."""
import wave
import numpy as np


# Generate two sine waves to represent the two stereo channels.
# The sample rate is 44100 and the DURATION is 5 seconds.

SAMPLERATE = 768000
DURATION = 1
F0 = 20
F1 = 2000

t = np.linspace(0, DURATION, SAMPLERATE * DURATION)

stereo = np.empty((2, len(t)))
stereo[0] = np.sin(2 * np.pi * F0 * t)  # left channel
stereo[1] = np.sin(2 * np.pi * F1 * t)  # right channel

# Convert the numpy array to audio file.
stereo = np.transpose(stereo)
stereo *= 32767
stereo = np.int32(stereo)

with wave.open("sound.sample.wav", "wb") as f:
    # f.setparams((2, 2, SAMPLERATE, 0, 'NONE', 'not compressed'))
    f.setnchannels(2)
    f.setsampwidth(2)
    f.setframerate(SAMPLERATE)
    f.writeframes(stereo.tobytes())
