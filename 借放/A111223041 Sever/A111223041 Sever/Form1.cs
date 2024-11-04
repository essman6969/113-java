﻿using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Sockets;
using System.Net;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace A111223041_Sever
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        TcpListener Server;
        Socket Client;
        Thread Th_Svr;
        Thread Th_Clt;
        Hashtable HT = new Hashtable();
        private void Form1_Load(object sender, EventArgs e)
        {
            textBox1.Text = MyIP();
        }
        private string MyIP()
        {
            string hn = Dns.GetHostName();
            IPAddress[] ip = Dns.GetHostEntry(hn).AddressList;
            foreach (IPAddress it in ip)
            {
                if (it.AddressFamily == AddressFamily.InterNetwork)
                {
                    return it.ToString();
                }
            }
            return "";
        }
        
        private void ServerSub()
        {
            IPEndPoint EP = new IPEndPoint(IPAddress.Parse(textBox1.Text), int.Parse(textBox2.Text));
            Server = new TcpListener(EP);
            Server.Start(100);
            while (true)
            {
                Client = Server.AcceptSocket();
                Th_Clt = new Thread(Listen);
                Th_Clt.IsBackground = true;
                Th_Clt.Start();
            }

        }
        private void Listen()
        {
            Socket Sck = Client;
            Thread Th = Th_Clt;
            while (true)
            {
                try
                {
                    byte[] B = new byte[1023];
                    int inLen = Sck.Receive(B);
                    String Msg = Encoding.Default.GetString(B, 0, inLen);
                    listBox2.Items.Add("(接收)" + Msg);
                    string Cmd = Msg.Substring(0, 1);
                    string Str = Msg.Substring(1);
                    switch (Cmd)
                    {
                        case "0":
                            if (listBox1.Items.IndexOf(Str) < 0)
                            {
                                HT.Add(Str, Sck);
                                listBox1.Items.Add(Str);
                                SendAll(OnlineList());
                            }
                            else
                            {
                                byte[] R = Encoding.Default.GetBytes("3" + "使用者名稱重複");
                                Sck.Send(R, 0, R.Length, SocketFlags.None);
                                Th.Abort();
                            }
                            break;
                        case "9":
                            HT.Remove(Str);
                            listBox1.Items.Remove(Str);
                            SendAll(OnlineList());
                            Th.Abort();
                            break;
                        case "1":
                            SendAll(Msg);
                            break;
                        default:
                            string[] C = Str.Split('|');
                            SendTo(Cmd + C[0], C[1]);
                            break;
                    }
                }
                catch (Exception)
                {

                }
            }
        }
        private string OnlineList()
        {
            String L = "L";
            for (int i = 0; i < listBox1.Items.Count; i++)
            {
                L += listBox1.Items[i];
                if (i < listBox1.Items.Count - 1)
                    L += ",";
            }
            return L;
        }
        private void SendTo(string Str, string User)
        {
            byte[] B = Encoding.Default.GetBytes(Str);
            Socket Sck = (Socket)HT[User];
            Sck.Send(B, 0, B.Length, SocketFlags.None);
            listBox2.Items.Add("(傳送給)" + User + ":" + Str);
        }
        private void SendAll(string Str)
        {
            byte[] B = Encoding.Default.GetBytes(Str);
            foreach (Socket s in HT.Values)
            {
                s.Send(B, 0, B.Length, SocketFlags.None);
            }
        }

        

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void listBox2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            CheckForIllegalCrossThreadCalls = false;
            Th_Svr = new Thread(ServerSub);
            Th_Svr.IsBackground = true;
            Th_Svr.Start();
            button1.Enabled = false;
        }

        private void Form1_FormClosing_1(object sender, FormClosingEventArgs e)
        {
            Application.ExitThread();
        }
    }
}
