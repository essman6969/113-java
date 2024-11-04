using System;
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

namespace A111223041_client
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        Socket T;
        Thread Th;
        string User;

        private void Form1_Load(object sender, EventArgs e)
        {
            button2.Enabled = false;
            button3.Enabled = false;
        }

        
        private void Send(string Str)
        {
            byte[] B = Encoding.Default.GetBytes(Str);
            T.Send(B, 0, B.Length, SocketFlags.None);
        }

        private void Listen()
        {
            EndPoint ServerEP = (EndPoint)T.RemoteEndPoint;
            byte[] B = new byte[1023];
            int inLen = 0;
            string Msg;
            string St;
            string Str;
            while (true)
            {
                try
                {
                    inLen = T.ReceiveFrom(B, ref ServerEP);
                }
                catch (Exception)
                {
                    T.Close();
                    listBox1.Items.Clear();
                    MessageBox.Show("伺服器斷線");
                    button1.Enabled = true;
                    Th.Abort();
                }
                Msg = Encoding.Default.GetString(B, 0, inLen);
                St = Msg.Substring(0, 1);
                Str = Msg.Substring(1);
                switch (St)
                {
                    case "L":
                        listBox1.Items.Clear();
                        string[] M = Str.Split(',');
                        for (int i = 0; i < M.Length; i++)
                        {
                            listBox1.Items.Add(M[i]);
                        }
                        break;
                    case "1":
                        listBox2.Items.Add("公開" + Str);
                        break;
                    case "2":
                        listBox2.Items.Add("私密" + Str);
                        break;
                    case "3":
                        listBox2.Items.Add("使用者名稱重複");
                        button1.Enabled = true;

                        Th.Abort();

                        break;
                }
            }
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (button1.Enabled == false)
            {
                Send("9" + User);
                T.Close();
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            if (textBox4.Text == "") return;
            if (listBox1.SelectedIndex >= 0)
            {
                Send("2" + "來自" + User + ":" + textBox4.Text + "|" + listBox1.SelectedItem);
                listBox2.Items.Add("告訴" + listBox1.SelectedItem + ":" + textBox4.Text);
            }
            else
            {
                MessageBox.Show("請選取傳送的對象");
            }
            textBox4.Text = "";
        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            if (textBox4.Text == "") return;
            Send("1" + User + "公告:" + textBox4.Text);
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            CheckForIllegalCrossThreadCalls = false;
            string IP = textBox1.Text;
            int Port = int.Parse(textBox2.Text);
            IPEndPoint EP = new IPEndPoint(IPAddress.Parse(IP), Port);
            T = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            User = textBox3.Text;
            if (User != "")
            {
                try
                {
                    T.Connect(EP);
                    Th = new Thread(Listen);
                    Th.IsBackground = true;
                    Th.Start();
                    listBox2.Items.Add("已連線伺服器");
                    Send("0" + User);
                }
                catch (Exception ex)
                {
                    listBox2.Items.Add("無法連上伺服器");
                    return;
                }
                button1.Enabled = false;
                button2.Enabled = true;
                button3.Enabled = true;
            }
            else
            {
                MessageBox.Show("Error");
            }
        }

        private void Form1_FormClosing_1(object sender, FormClosingEventArgs e)
        {
            if (button1.Enabled == false)
            {
                Send("9" + User);
                T.Close();
            }
        }
    }
}