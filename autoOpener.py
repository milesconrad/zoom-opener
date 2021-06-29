from sys import exit
from threading import Thread
from time import sleep, strftime as getdate
import tkinter
from tkinter import messagebox
from webbrowser import open as openURL

urls = [
    'https://oneoakland.webex.com/meet/chisnell',
    'https://oneoakland.webex.com/meet/david.weeks',
    'https://oneoakland.webex.com/meet/kirsten.williams',
    'https://oneoakland.webex.com/meet/mrcastle',
    'https://oneoakland.webex.com/meet/alec.snyder',
    'https://oneoakland.webex.com/meet/kristen.elsner',
    'https://oneoakland.webex.com/meet/jennifer.hull'
]
schedule = [
    {
        'Monday' : [('12:59:30', 0)],
        'Monday Wednesday Friday' : [('07:52:30', 1), ('09:24:30', 2), ('10:54:30', 3)],
        'Tuesday Thursday' : [('07:52:30', 4), ('09:24:30', 5), ('10:54:30', 6)],
    },
    {
        'Monday' : [('12:59:30', 0)],
        'Monday Wednesday Friday' : [('07:52:30', 4), ('09:24:30', 5), ('10:54:30', 6)],
        'Tuesday Thursday' : [('07:52:30', 1), ('09:24:30', 2), ('10:54:30', 3)],
    }
]
running = False
lastButton = None
lastTitle = None

def createButton(context, text, x, y, width, function):
    button = tkinter.Button(context, command=function, text=text, font=('arial bold', 10,))
    button.place(x=x, y=y, width=width, height=30)
    return button

def autoOpen(schedule):
    while running:
        currentTime = getdate('%H:%M:%S')
        currentDay = getdate('%A')

        for days in schedule:
            if days.find(currentDay) != -1:
                for times in schedule[days]:
                    if currentTime == times[0]:
                        openURL(urls[times[1]])
                        sleep(2)
        sleep(0.5)
    exit()

def startLoop(scheduleChoice, schedule, button):
    global running
    global lastButton
    global lastTitle
    # makes sure you can't start another thread when one is already running
    if not running:
        schedule = schedule[scheduleChoice]

        lastButton = button
        lastTitle = lastButton.cget('text')
        lastButton.config(text='Running...')

        running = True
        Thread(target=autoOpen, args=(schedule,)).start()

def stopLoop():
    global running
    global lastButton
    global lastTitle
    # stops the thread and changes the button title back to what it was
    if running:
        lastButton.config(text=lastTitle)
        running = False 

window = tkinter.Tk()
window.title('Auto Zoom Opener')
# these values must be converted to integers, because division returns floats
width = int(window.winfo_screenwidth()/2-150)
height = int(window.winfo_screenheight()/2-250)
window.geometry(f'500x315+{width}+{height}')

# the following positions seem random, but they are all spaced out perfectly and
# compensate for the different lengths and heights of window elements
title = tkinter.Label(window, text='Auto Zoom Opener', font=('arial bold', 12,))
title.place(x=150, y=30, width=200, height=15)

createButton(window, 'First', 55, 75, 90, lambda:openURL(urls[1]))
createButton(window, 'Second', 155, 75, 90, lambda:openURL(urls[2]))
createButton(window, 'Third', 255, 75, 90, lambda:openURL(urls[3]))
createButton(window, 'Fourth', 355, 75, 90, lambda:openURL(urls[4]))
createButton(window, 'Fifth', 100, 115, 90, lambda:openURL(urls[5]))
createButton(window, 'Sixth', 200, 115, 90, lambda:openURL(urls[6]))
createButton(window, 'Advisory', 300, 115, 90, lambda:openURL(urls[0]))

auto123btn = createButton(window, 'Auto Open (1, 2, 3)', 175, 175, 150, lambda:startLoop(0, schedule, auto123btn))
auto456btn = createButton(window, 'Auto Open (4, 5, 6)', 175, 215, 150, lambda:startLoop(1, schedule, auto456btn))
createButton(window, 'Cancel', 205, 255, 90, stopLoop)

def ask_quit():
    global running
    if running:
        if tkinter.messagebox.askokcancel('Quit', 'The auto opener is still running, are you sure you want to quit?'):
            running = False
            window.destroy()
    else:
        window.destroy()
window.protocol('WM_DELETE_WINDOW', ask_quit)

window.mainloop()